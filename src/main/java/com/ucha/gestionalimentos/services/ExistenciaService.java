package com.ucha.gestionalimentos.services;

import com.ucha.gestionalimentos.dto.existencia.ExistenciaDTO;
import com.ucha.gestionalimentos.entities.Existencia;
import com.ucha.gestionalimentos.exception.UbicacionNoEncontradaException;
import com.ucha.gestionalimentos.repositories.ExistenciaRepository;
import com.ucha.gestionalimentos.repositories.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExistenciaService {

    private final ExistenciaRepository existenciaRepository;
    private final UbicacionRepository ubicacionRepository;

    public ExistenciaService(ExistenciaRepository existenciaRepository, UbicacionRepository ubicacionRepository) {
        this.existenciaRepository = existenciaRepository;
        this.ubicacionRepository = ubicacionRepository;
    }

    // Metodo para convertir una entidad Existencia a su DTO
    private ExistenciaDTO convertirExistencia(Existencia existencia) {
        ExistenciaDTO dto = new ExistenciaDTO();
        dto.setId(existencia.getId());
        dto.setAlimentoid(existencia.getAlimento().getId());
        dto.setUbicacionid(existencia.getUbicacion().getId());
        dto.setCantidad(existencia.getCantidad());
        dto.setFecha_entrada(existencia.getFecha_entrada());
        return dto;
    }

    // Metodo para obtener existencias por ubicación
    public List<ExistenciaDTO> obtenerExistenciasPorUbicacion(Long ubicacionId) {
        // Verificar que la ubicación exista
        ubicacionRepository.findById(ubicacionId)
                .orElseThrow(() -> new UbicacionNoEncontradaException("Ubicación no encontrada"));

        // Obtener existencias por ubicación
        List<Existencia> existencias = existenciaRepository.findByUbicacionId(ubicacionId);

        // Convertir a DTO y retornar
        return existencias.stream()
                .map(this::convertirExistencia)
                .collect(Collectors.toList());
    }

    // Metodo para obtener existencias por alimento, ordenadas por fecha de entrada
    public List<ExistenciaDTO> obtenerExistenciasPorFechaEntrada(Long alimentoId) {
        // Obtener las existencias del alimento ordenadas por fecha de entrada ascendente
        List<Existencia> existencias = existenciaRepository.findByAlimentoIdOrderByFechaEntradaAsc(alimentoId);

        // Convertir las entidades a DTO
        return existencias.stream()
                .map(this::convertirExistencia)
                .collect(Collectors.toList());
    }
}

