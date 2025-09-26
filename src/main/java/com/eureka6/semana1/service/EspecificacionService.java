package com.eureka6.semana1.service;

import com.eureka6.semana1.entity.Especificacion;
import com.eureka6.semana1.exception.ResourceNotFoundException;
import com.eureka6.semana1.repository.EspecificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class EspecificacionService {

    private final EspecificacionRepository especificacionRepository;
    public List<Especificacion> listarTodas() {
        return especificacionRepository.findAll();
    }

    public Especificacion obtenerPorId(Integer id) {
        return especificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la especificación con ID: " + id));
    }

    public List<Especificacion> listarPorOfertaId(Integer ofertaId) {
        return especificacionRepository.findByOferta_Id(ofertaId)
                .map(Collections::singletonList)
                .orElseGet(Collections::emptyList);
    }

    @Transactional
    public Especificacion crear(Especificacion especificacion) {
        return especificacionRepository.save(especificacion);
    }

    @Transactional
    public void eliminar(Integer id) {
        if (!especificacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe la especificación con ID: " + id);
        }
        especificacionRepository.deleteById(id);
    }
}
