package com.eureka6.semana1.service;

import com.eureka6.semana1.entity.Oferta;
import com.eureka6.semana1.exception.ResourceNotFoundException;
import com.eureka6.semana1.repository.OfertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfertaService {

    private final OfertaRepository ofertaRepository;

    public List<Oferta> findAll() {
        return ofertaRepository.findAll();
    }

    public Oferta findById(Integer id) {
        return ofertaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la oferta con ID: " + id));
    }
}
