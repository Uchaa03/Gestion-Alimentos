package com.ucha.gestionalimentos.dto.ubicacion;

import com.ucha.gestionalimentos.dto.existencia.ExistenciaDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter @Setter
public class UbicacionDTO {
    private Long id;
    private String descripcion;
    private String tipo_ubicacion;
    private Long capacidad;
    private List<ExistenciaDTO> existencias;
}
