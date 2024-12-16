package com.ucha.gestionalimentos.repositories;

import com.ucha.gestionalimentos.entities.Alimento;
import com.ucha.gestionalimentos.entities.Existencia;
import com.ucha.gestionalimentos.entities.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExistenciaRepository extends JpaRepository<Existencia, Long> {
    // Buscar las existencias de un alimento específico
    List<Existencia> findByAlimentoIdOrderByFechaEntradaAsc(Long alimentoId);

    // Buscar existencias por ubicación
    List<Existencia> findByUbicacionId(Long ubicacionId);

    Existencia findByAlimentoAndUbicacion(Alimento alimento, Ubicacion ubicacionOrigen);
}