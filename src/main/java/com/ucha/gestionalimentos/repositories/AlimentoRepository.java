package com.ucha.gestionalimentos.repositories;

import com.ucha.gestionalimentos.entities.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    // Obtener alimentos cuya fecha de caducidad esté dentro de los próximos 7 días
    List<Alimento> findByFechaCaducidadBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
