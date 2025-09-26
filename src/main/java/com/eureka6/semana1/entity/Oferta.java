package com.eureka6.semana1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ofertas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "solicitud_id")
    private Integer solicitudId; // FK pero no aplica para este caso.

    @Size(max = 200)
    @Column(length = 200)
    private String titulo;

    @Size(max = 50)
    @Column(length = 50)
    private String estado;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String descripcion;

    @Lob
    @Column(name = "requisitos_minimos", columnDefinition = "LONGTEXT")
    private String requisitosMinimos;

    private Integer anonima; 
    @Size(max = 50)
    @Column(length = 50)
    private String area;

    @Size(max = 50)
    @Column(length = 50)
    private String idioma;

    @Size(max = 50)
    @Column(length = 50)
    private String pais;

    @Size(max = 150)
    @Column(length = 150)
    private String localizacion;

    @Size(max = 30)
    @Column(name = "salario_modalidad", length = 30)
    private String salarioModalidad;
    @Size(max = 30)
    @Column(name = "salario_moneda", length = 30)
    private String salarioMoneda;

    @Column(name = "salario_desde")
    private Integer salarioDesde;

    @Column(name = "salario_hasta")
    private Integer salarioHasta;

    @Column(name = "salario_mostrar")
    private Integer salarioMostrar;

    @OneToOne(mappedBy = "oferta", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private Especificacion especificacion;
}
