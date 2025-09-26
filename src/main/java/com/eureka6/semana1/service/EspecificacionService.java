package com.eureka6.semana1.service;

import com.eureka6.semana1.entity.Especificacion;
import com.eureka6.semana1.repository.EspecificacionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecificacionService {

    private final EspecificacionRepository especificacionRepository;

    public List<Especificacion> listarTodas() {
        return especificacionRepository.findAll();
    }

    public Especificacion obtenerPorId(Integer id) {
        return especificacionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Especificación no encontrada"));
    }

    public List<Especificacion> listarPorOfertaId(Integer ofertaId) {
        return especificacionRepository.findByOfertaId(ofertaId);
    }

    @Transactional
    public Especificacion crear(Especificacion especificacion) {
        return especificacionRepository.save(especificacion);
    }

    @Transactional
    public void eliminar(Integer id) {
        if (!especificacionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especificación no encontrada");
        }
        especificacionRepository.deleteById(id);
    }
}
