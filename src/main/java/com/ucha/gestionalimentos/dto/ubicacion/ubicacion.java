package com.ucha.gestionalimentos.dto.ubicacion;

import com.ucha.gestionalimentos.entities.Existencia;
import lombok.Data;

import java.util.List;

@Data
public class ubicacion {
    private Long id;
    private String descripcion;
    private String tipo_ubicacion;
    private Long capacidad;
    private List<Existencia> existencias;
}
