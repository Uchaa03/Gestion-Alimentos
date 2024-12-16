package com.ucha.gestionalimentos.services;

import com.ucha.gestionalimentos.dto.existencia.ExistenciaDTO;
import com.ucha.gestionalimentos.dto.ubicacion.UbicacionDTO;
import com.ucha.gestionalimentos.entities.Existencia;
import com.ucha.gestionalimentos.entities.Ubicacion;
import com.ucha.gestionalimentos.repositories.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    // Pasar existencia a DTO
    private ExistenciaDTO convertirExistencia(Existencia existencia) {
        ExistenciaDTO dto = new ExistenciaDTO();
        dto.setId(existencia.getId());
        dto.setAlimentoid(existencia.getAlimento().getId());  // Mapeo del alimento relacionado
        dto.setCantidad(existencia.getCantidad());
        dto.setFecha_entrada(existencia.getFecha_entrada());
        return dto;
    }

    // Método para obtener existencias por ubicación
    public UbicacionDTO obtenerExistenciasPorUbicacion(Long ubicacionId) {
        // Buscar ubicación por ID
        Ubicacion ubicacion = ubicacionRepository.findById(ubicacionId)
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));

        // Mapear ubicación a DTO
        UbicacionDTO dto = new UbicacionDTO();
        dto.setId(ubicacion.getId());
        dto.setDescripcion(ubicacion.getDescripcion());
        dto.setTipo_ubicacion(ubicacion.getTipo_ubicacion());
        dto.setCapacidad(ubicacion.getCapacidad());

        // Mapear existencias a DTO
        List<ExistenciaDTO> existenciasDTO = ubicacion.getExistencias().stream()
                .map(this::convertirExistencia)  // Usamos el método de conversión manual
                .collect(Collectors.toList());

        // Asignar las existencias mapeadas al DTO de la ubicación
        dto.setExistencias(existenciasDTO);

        return dto;
    }
}
