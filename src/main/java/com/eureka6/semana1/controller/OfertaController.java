package com.eureka6.semana1.controller;

import com.eureka6.semana1.dto.OfertaDTO;
import com.eureka6.semana1.entity.Oferta;
import com.eureka6.semana1.service.OfertaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ofertas")
@RequiredArgsConstructor
public class OfertaController {

    private final OfertaService ofertaService;
    private final ModelMapper modelMapper;
    //GET
    @GetMapping
    public ResponseEntity<List<OfertaDTO>> findAll() {
        List<OfertaDTO> ofertaDTOS = ofertaService.findAll().stream().map(
            oferta -> {
                return modelMapper.map(oferta, OfertaDTO.class);
            }
        ).collect(Collectors.toList());

        return ResponseEntity.ok(ofertaDTOS);
        
    }
    //GET X ID  
    @GetMapping("/{id}")
    public ResponseEntity<OfertaDTO> findById(@PathVariable Integer id) {
        Optional<Oferta> ofertaOptional = ofertaService.findById(id);

        return ofertaOptional.map(
            ofertaDB -> {
                return ResponseEntity.ok(modelMapper.map(ofertaDB, OfertaDTO.class));
            }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
