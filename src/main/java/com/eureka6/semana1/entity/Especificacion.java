package com.eureka6.semana1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "especificaciones", indexes = {
        @Index(name = "idx_especificacion_oferta_id", columnList = "oferta_id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Especificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "oferta_id", nullable = false)
    private Integer ofertaId; // Asociación explícita por atributo en común con Oferta.id

    @Column(name = "numero_vacantes")
    private Integer numeroVacantes;

    @Column(name = "personal_a_cargo")
    private Integer personalACargo;

    @Size(max = 100)
    @Column(name = "modalidad_trabajo", length = 100)
    private String modalidadTrabajo;

    @Size(max = 100)
    @Column(length = 100)
    private String categoria;

    @Size(max = 100)
    @Column(length = 100)
    private String sector;

    @Size(max = 100)
    @Column(name = "nivel_profesional", length = 100)
    private String nivelProfesional;

    @Size(max = 100)
    @Column(length = 100)
    private String departamento;

    @Size(max = 100)
    @Column(name = "experiencia_minima", length = 100)
    private String experienciaMinima;

    @Size(max = 100)
    @Column(name = "jornada_laboral", length = 100)
    private String jornadaLaboral;

    @Size(max = 100)
    @Column(name = "formacion_minima", length = 100)
    private String formacionMinima;
}
