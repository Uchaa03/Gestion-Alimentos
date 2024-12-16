package com.ucha.gestionalimentos.controllers;

import com.ucha.gestionalimentos.dto.alimento.AlimentoDTO;
import com.ucha.gestionalimentos.dto.alimento.MoverAlimentoDTO;
import com.ucha.gestionalimentos.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

    private final AlimentoService alimentoService;

    @Autowired
    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    // Obtener todos los alimentos
    @GetMapping
    public ResponseEntity<List<AlimentoDTO>> obtenerTodosLosAlimentos() {
        List<AlimentoDTO> alimentos = alimentoService.obtenerTodosLosAlimentos();
        return ResponseEntity.ok(alimentos);
    }

    // Obtener alimento por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlimentoDTO> obtenerAlimentoPorId(@PathVariable Long id) {
        AlimentoDTO alimento = alimentoService.obtenerAlimentoPorId(id);
        return ResponseEntity.ok(alimento);
    }

    // Obtener alimentos próximos a caducar
    @GetMapping("/proximos-a-caducar")
    public ResponseEntity<List<AlimentoDTO>> obtenerAlimentosProximosACaducar() {
        List<AlimentoDTO> alimentosProximos = alimentoService.obtenerAlimentosProximosACaducar();
        return ResponseEntity.ok(alimentosProximos);
    }

    // Mover alimento entre ubicaciones
    @PostMapping("/mover")
    public ResponseEntity<Void> moverAlimento(@RequestBody MoverAlimentoDTO moverAlimentoDTO) {
        alimentoService.moverAlimento(moverAlimentoDTO);
        return ResponseEntity.noContent().build(); // Respuesta sin contenido
    }

    // Eliminar alimento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlimento(@PathVariable Long id) {
        alimentoService.eliminarAlimento(id);
        return ResponseEntity.noContent().build();
    }
}

