package com.eureka6.semana1.controller;

import com.eureka6.semana1.dto.EspecificacionDTO;
import com.eureka6.semana1.entity.Especificacion;
import com.eureka6.semana1.service.EspecificacionService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/especificaciones")

public class EspecificacionController {
    private final EspecificacionService especificacionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<EspecificacionDTO> findAll(@RequestParam(required = false) Integer ofertaId) {
        List<Especificacion> entidades = (ofertaId != null)
                ? especificacionService.listarPorOfertaId(ofertaId)
                : especificacionService.listarTodas();
        return entidades.stream()
                .map(e -> modelMapper.map(e, EspecificacionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EspecificacionDTO obtener(@PathVariable Integer id) {
        Especificacion entidad = especificacionService.obtenerPorId(id);
        return modelMapper.map(entidad, EspecificacionDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EspecificacionDTO crear(@Valid @RequestBody EspecificacionDTO dto) {
        Especificacion entidad = modelMapper.map(dto, Especificacion.class);
        Especificacion guardado = especificacionService.crear(entidad);
        return modelMapper.map(guardado, EspecificacionDTO.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        especificacionService.eliminar(id);
    }
}
