package com.ucha.gestionalimentos.repositories;

import com.ucha.gestionalimentos.entities.Existencia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExistenciaRepository {
    // Buscar las existencias de un alimento específico
    List<Existencia> findByAlimentoIdOrderByFechaEntradaAsc(Long alimentoId);

    // Buscar existencias por ubicación
    List<Existencia> findByUbicacionId(Long ubicacionId);
}
