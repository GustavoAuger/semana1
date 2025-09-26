package com.eureka6.semana1.repository;

import com.eureka6.semana1.entity.Especificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspecificacionRepository extends JpaRepository<Especificacion, Integer> {
    Optional<Especificacion> findByOferta_Id(Integer ofertaId);
}
