package com.eureka6.semana1.controller;

import com.eureka6.semana1.entity.Especificacion;
import com.eureka6.semana1.service.EspecificacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/especificaciones")
@RequiredArgsConstructor
public class EspecificacionController {

    private final EspecificacionService especificacionService;

    @GetMapping
    public List<Especificacion> listar(@RequestParam(value = "ofertaId", required = false) Integer ofertaId) {
        if (ofertaId != null) {
            return especificacionService.listarPorOfertaId(ofertaId);
        }
        return especificacionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Especificacion obtener(@PathVariable Integer id) {
        return especificacionService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Especificacion crear(@Valid @RequestBody Especificacion especificacion) {
        return especificacionService.crear(especificacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        especificacionService.eliminar(id);
    }
}
