package com.ucha.gestionalimentos.controllers;

import com.ucha.gestionalimentos.dto.existencia.ExistenciaDTO;
import com.ucha.gestionalimentos.services.ExistenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/existencias")
public class ExistenciaController {

    private final ExistenciaService existenciaService;

    public ExistenciaController(ExistenciaService existenciaService) {
        this.existenciaService = existenciaService;
    }

    // Endpoint para obtener existencias por ubicación
    @GetMapping("/ubicacion/{ubicacionId}")
    public ResponseEntity<List<ExistenciaDTO>> obtenerExistenciasPorUbicacion(@PathVariable Long ubicacionId) {
        List<ExistenciaDTO> existencias = existenciaService.obtenerExistenciasPorUbicacion(ubicacionId);
        return ResponseEntity.ok(existencias);
    }

    // Endpoint para obtener existencias por alimento ordenadas por fecha de entrada
    @GetMapping("/alimento/{alimentoId}/ordenadas-por-fecha")
    public ResponseEntity<List<ExistenciaDTO>> obtenerExistenciasPorFechaEntrada(@PathVariable Long alimentoId) {
        List<ExistenciaDTO> existencias = existenciaService.obtenerExistenciasPorFechaEntrada(alimentoId);
        return ResponseEntity.ok(existencias);
    }
}
