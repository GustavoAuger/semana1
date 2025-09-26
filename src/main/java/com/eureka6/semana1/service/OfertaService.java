package com.eureka6.semana1.service;

import com.eureka6.semana1.entity.Oferta;
import com.eureka6.semana1.repository.OfertaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfertaService {

    private final OfertaRepository ofertaRepository;

    public List<Oferta> listarTodas() {
        return ofertaRepository.findAll();
    }

    public Oferta obtenerPorId(Integer id) {
        return ofertaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Oferta no encontrada"));
    }
}
