package com.ucha.gestionalimentos.controllers;

import com.ucha.gestionalimentos.dto.ubicacion.UbicacionDTO;
import com.ucha.gestionalimentos.services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    @Autowired
    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    // Obtener las existencias por ubicación
    @GetMapping("/{ubicacionId}/existencias")
    public ResponseEntity<UbicacionDTO> obtenerExistenciasPorUbicacion(@PathVariable Long ubicacionId) {
        try {
            UbicacionDTO ubicacionDTO = ubicacionService.obtenerExistenciasPorUbicacion(ubicacionId);
            return ResponseEntity.ok(ubicacionDTO);
        } catch (RuntimeException e) {
            // Si ocurre un error (como no encontrar la ubicación), devolvemos un 404
            return ResponseEntity.notFound().build();
        }
    }
}
