package com.ucha.gestionalimentos.dto.alimento;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AgregarAlimentoDTO {
    private String nombre;
    private String tipo; // perecedero o no perecedero
    private String estado; // abierto o cerrado
    private LocalDate fechaCaducidad;
}
