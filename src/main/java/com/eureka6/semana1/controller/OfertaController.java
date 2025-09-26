package com.eureka6.semana1.controller;

import com.eureka6.semana1.entity.Oferta;
import com.eureka6.semana1.service.OfertaService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/ofertas")
@RequiredArgsConstructor
public class OfertaController {

    private final OfertaService ofertaService;

    @GetMapping
    public List<Oferta> listar() {
        return ofertaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Oferta obtener(@PathVariable Integer id) {
        return ofertaService.obtenerPorId(id);
    }
}
