package com.eureka6.semana1.repository;

import com.eureka6.semana1.entity.Especificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecificacionRepository extends JpaRepository<Especificacion, Integer> {
    List<Especificacion> findByOfertaId(Integer ofertaId);
}
