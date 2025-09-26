package com.eureka6.semana1.service;

import com.eureka6.semana1.entity.Oferta;
import com.eureka6.semana1.repository.OfertaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfertaService {

    private final OfertaRepository ofertaRepository;

    public List<Oferta> listarTodas() {
        return findAll();
    }

    public Oferta obtenerPorId(Integer id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Oferta no encontrada"));
    }

    public List<Oferta> findAll() {
        return ofertaRepository.findAll();
    }

    public Optional<Oferta> findById(Integer id) {
        return ofertaRepository.findById(id);
    }
}