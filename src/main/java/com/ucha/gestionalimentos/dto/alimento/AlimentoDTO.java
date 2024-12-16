package com.ucha.gestionalimentos.dto.alimento;

import com.ucha.gestionalimentos.entities.Existencia;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter @Setter
public class AlimentoDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private String estado;
    private LocalDate fecha_caducidad;
    private List<Existencia> existencias; //Le pasamos el DTO de existencias
}
