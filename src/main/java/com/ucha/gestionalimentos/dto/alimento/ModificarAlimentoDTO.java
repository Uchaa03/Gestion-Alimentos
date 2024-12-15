package com.ucha.gestionalimentos.dto.alimento;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModificarAlimentoDTO {
    private Long id; // ID necesario para identificar el alimento a actualizar
    private String nombre;
    private String tipo; // perecedero o no perecedero
    private String estado; // abierto o cerrado
    private LocalDate fechaCaducidad;
}
