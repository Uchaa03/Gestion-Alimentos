package com.ucha.gestionalimentos.services;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentoService {

    private final AlimentoRepository alimentoRepository;

    private final UbicacionRepository ubicacionRepository;

    private final ExistenciaRepository existenciaRepository;

    public AlimentoService(AlimentoRepository alimentoRepository, UbicacionRepository ubicacionRepository, ExistenciaRepository existenciaRepository) {
        this.alimentoRepository = alimentoRepository;
        this.ubicacionRepository = ubicacionRepository;
        this.existenciaRepository = existenciaRepository;
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
}

