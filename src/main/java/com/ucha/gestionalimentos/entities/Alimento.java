package com.ucha.gestionalimentos.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.micrometer.observation.annotation.Observed;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString //Para simplificar la creación de un elemento
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull //Para que los campos sean obligatorios
    private String nombre;
    private String tipo; //perecedero o no perecedero
    private String estado; //abierto o cerrado
    private LocalDate fecha_caducidad; //Mejor que date, ya que solo queremos la fecha

    @OneToMany(mappedBy = "alimento", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonManagedReference
    private List<Existencia> existencias; //Propietario de la relación
}