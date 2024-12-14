package com.ucha.gestionalimentos.repositories;

import com.ucha.gestionalimentos.entities.Alimento;
import com.ucha.gestionalimentos.entities.Existencia;
import com.ucha.gestionalimentos.entities.Ubicacion;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UbicacionRepository {
    // Buscar todas las ubicaciones
    List<Ubicacion> findAll();

    // Buscar una ubicación por su tipo (por ejemplo, "congelador")
    List<Ubicacion> findByTipoUbicacion(String tipoUbicacion);
}
