package com.ucha.gestionalimentos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class Existencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "alimento_id")
    @JsonBackReference // Lado no propietario de la relación, lado inverso de la relacilón
    private Alimento alimento;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    @JsonBackReference // Lado no propietario de la relación, lado inverso de la relacilón
    private Ubicacion ubicacion;
    private Long cantidad;
    private LocalDate fecha_entrada;
}
