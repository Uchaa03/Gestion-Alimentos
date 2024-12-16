package com.ucha.gestionalimentos.dto.existencia;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter @Setter
public class ExistenciaDTO {
    private Long id;
    private Long alimentoid;
    private Long ubicacionid;
    private Long cantidad;
    private LocalDate fecha_entrada;
}
