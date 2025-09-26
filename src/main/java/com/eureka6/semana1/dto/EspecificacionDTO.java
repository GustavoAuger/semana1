package com.eureka6.semana1.dto;    

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspecificacionDTO {
    private Integer id;

    @NotNull
    private Integer ofertaId;

    private Integer numeroVacantes;

    private Integer personalACargo;

    @Size(max = 100)
    private String modalidadTrabajo;

    @Size(max = 100)
    private String categoria;

    @Size(max = 100)
    private String sector;

    @Size(max = 100)
    private String nivelProfesional;

    @Size(max = 100)
    private String departamento;

    @Size(max = 100)
    private String experienciaMinima;

    @Size(max = 100)
    private String jornadaLaboral;

    @Size(max = 100)
    private String formacionMinima;
}
