package com.ucha.gestionalimentos.dto.alimento;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlimentoCaducacionProximaDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private LocalDate fechaCaducidad;
}
