package com.eureka6.semana1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "especificaciones", indexes = {
        @Index(name = "idx_especificacion_oferta_id", columnList = "oferta_id")
})
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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getOfertaId() { return ofertaId; }
    public void setOfertaId(Integer ofertaId) { this.ofertaId = ofertaId; }

    public Integer getNumeroVacantes() { return numeroVacantes; }
    public void setNumeroVacantes(Integer numeroVacantes) { this.numeroVacantes = numeroVacantes; }

    public Integer getPersonalACargo() { return personalACargo; }
    public void setPersonalACargo(Integer personalACargo) { this.personalACargo = personalACargo; }

    public String getModalidadTrabajo() { return modalidadTrabajo; }
    public void setModalidadTrabajo(String modalidadTrabajo) { this.modalidadTrabajo = modalidadTrabajo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public String getNivelProfesional() { return nivelProfesional; }
    public void setNivelProfesional(String nivelProfesional) { this.nivelProfesional = nivelProfesional; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getExperienciaMinima() { return experienciaMinima; }
    public void setExperienciaMinima(String experienciaMinima) { this.experienciaMinima = experienciaMinima; }

    public String getJornadaLaboral() { return jornadaLaboral; }
    public void setJornadaLaboral(String jornadaLaboral) { this.jornadaLaboral = jornadaLaboral; }

    public String getFormacionMinima() { return formacionMinima; }
    public void setFormacionMinima(String formacionMinima) { this.formacionMinima = formacionMinima; }
}
