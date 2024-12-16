package com.ucha.gestionalimentos.services;

import com.ucha.gestionalimentos.dto.alimento.AlimentoDTO;
import com.ucha.gestionalimentos.dto.alimento.MoverAlimentoDTO;
import com.ucha.gestionalimentos.entities.Alimento;
import com.ucha.gestionalimentos.entities.Existencia;
import com.ucha.gestionalimentos.entities.Ubicacion;
import com.ucha.gestionalimentos.exception.AlimentoCantidadExistenciaNotFound;
import com.ucha.gestionalimentos.exception.AlimentoNotFound;
import com.ucha.gestionalimentos.exception.UbicacionNoEncontradaException;
import com.ucha.gestionalimentos.repositories.AlimentoRepository;
import com.ucha.gestionalimentos.repositories.ExistenciaRepository;
import com.ucha.gestionalimentos.repositories.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;
    private final ExistenciaRepository existenciaRepository;
    private final UbicacionRepository ubicacionRepository;

    public AlimentoService(AlimentoRepository alimentoRepository, ExistenciaRepository existenciaRepository, UbicacionRepository ubicacionRepository) {
        this.alimentoRepository = alimentoRepository;
        this.existenciaRepository = existenciaRepository;
        this.ubicacionRepository = ubicacionRepository;
    }

    //Pasar alimentos a DTO
    private AlimentoDTO convertirAlimento(Alimento alimento) {
        AlimentoDTO dto = new AlimentoDTO();
        dto.setId(alimento.getId());
        dto.setNombre(alimento.getNombre());
        dto.setTipo(alimento.getTipo());
        dto.setEstado(alimento.getEstado());
        dto.setFecha_caducidad(alimento.getFecha_caducidad());
        return dto;
    }

    // Metodo para obtener todos los alimentos
    public List<AlimentoDTO> obtenerTodosLosAlimentos() {
        // Obtener todos los alimentos
        List<Alimento> alimentos = alimentoRepository.findAll();
        // Mapear los alimentos a DTOs
        return alimentos.stream().map(this::convertirAlimento).collect(Collectors.toList());
    }

    // Metodo para obtener alimento por el id
    public AlimentoDTO obtenerAlimentoPorId(Long id) {
        Alimento alimento = alimentoRepository.findById(id)
                .orElseThrow(() -> new AlimentoNotFound("Alimento no encontrado"));

        return convertirAlimento(alimento);
    }

    // Metodo para obtener los alimentos próximos a caducar
    public List<AlimentoDTO> obtenerAlimentosProximosACaducar() {
        LocalDate fechaLimite = LocalDate.now().plusDays(7);

        // Obtener todos los alimentos
        List<Alimento> todosLosAlimentos = alimentoRepository.findAll();

        // Filtrar y mapear alimentos cuya fecha de caducidad está próxima
        return todosLosAlimentos.stream()
                .filter(alimento -> alimento.getFecha_caducidad() != null &&
                        alimento.getFecha_caducidad().isBefore(fechaLimite) &&
                        alimento.getFecha_caducidad().isAfter(LocalDate.now()))
                .map(this::convertirAlimento).collect(Collectors.toList());
    }

    // Lógica para mover un alimento entre ubicaciones
    public void moverAlimento(MoverAlimentoDTO dto) {
        // Buscar alimento, ubicaciones de origen y destino
        Alimento alimento = alimentoRepository.findById(dto.getAlimentoId())
                .orElseThrow(() -> new AlimentoNotFound("Alimento no encontrado"));

        // Buscar ubicaciones de origen y destino
        Ubicacion ubicacionOrigen = ubicacionRepository.findById(dto.getUbicacionOrigenId())
                .orElseThrow(() -> new UbicacionNoEncontradaException("Ubicación de origen no encontrada"));

        Ubicacion ubicacionDestino = ubicacionRepository.findById(dto.getUbicacionDestinoId())
                .orElseThrow(() -> new UbicacionNoEncontradaException("Ubicación de destino no encontrada"));

        // Verificar existencia en cantidad en la ubicación de origen
        Existencia existenciaOrigen = existenciaRepository.findByAlimentoAndUbicacion(alimento, ubicacionOrigen);
        if (existenciaOrigen == null || existenciaOrigen.getCantidad() < dto.getCantidad()) {
            throw new AlimentoCantidadExistenciaNotFound("Cantidad insuficiente en la ubicación de origen");
        }

        // Restar la cantidad del alimento en la ubicación de origen
        existenciaOrigen.setCantidad(existenciaOrigen.getCantidad() - dto.getCantidad());
        existenciaRepository.save(existenciaOrigen);

        // Agregar el alimento a la ubicación de destino
        Existencia existenciaDestino = existenciaRepository.findByAlimentoAndUbicacion(alimento, ubicacionDestino);
        if (existenciaDestino == null) {
            // Si no existe, crear una nueva entrada en la ubicación de destino
            existenciaDestino = new Existencia();
            existenciaDestino.setAlimento(alimento);
            existenciaDestino.setUbicacion(ubicacionDestino);
            existenciaDestino.setCantidad(dto.getCantidad());
            existenciaDestino.setFecha_entrada(java.time.LocalDate.now());        } else {
            // Si existe, simplemente actualizar la cantidad
            existenciaDestino.setCantidad(existenciaDestino.getCantidad() + dto.getCantidad());
        }
        existenciaRepository.save(existenciaDestino);
    }

    //Eliminar un elemento
    public void eliminarAlimento(Long id) {
        Alimento alimento = alimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

        // Eliminar alimento
        alimentoRepository.delete(alimento);
    }

}

