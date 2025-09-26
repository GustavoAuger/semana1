package com.eureka6.semana1.controller;

import com.eureka6.semana1.dto.EspecificacionDTO;
import com.eureka6.semana1.entity.Especificacion;
import com.eureka6.semana1.service.EspecificacionService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EspecificacionDTO>> findAll(@RequestParam(required = false) Integer ofertaId) {
        List<Especificacion> entidades = (ofertaId != null)
                ? especificacionService.listarPorOfertaId(ofertaId)
                : especificacionService.listarTodas();
        
        List<EspecificacionDTO> dtos = entidades.stream()
                .map(especificacion -> modelMapper.map(especificacion, EspecificacionDTO.class))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecificacionDTO> obtener(@PathVariable Integer id) {
        Especificacion entidad = especificacionService.obtenerPorId(id);
        EspecificacionDTO dto = modelMapper.map(entidad, EspecificacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EspecificacionDTO> crear(@Valid @RequestBody EspecificacionDTO dto) {
        Especificacion entidad = modelMapper.map(dto, Especificacion.class);
        Especificacion guardado = especificacionService.crear(entidad);
        EspecificacionDTO respuesta = modelMapper.map(guardado, EspecificacionDTO.class);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        especificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
