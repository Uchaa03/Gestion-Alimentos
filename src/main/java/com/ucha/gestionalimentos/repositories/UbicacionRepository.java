package com.ucha.gestionalimentos.repositories;

import com.ucha.gestionalimentos.entities.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    // Buscar una ubicación por su tipo (por ejemplo, "congelador")
    List<Ubicacion> findByTipoUbicacion(String tipoUbicacion);

}
