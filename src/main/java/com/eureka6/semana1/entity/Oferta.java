package com.eureka6.semana1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ofertas")
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "solicitud_id")
    private Integer solicitudId; // FK lógica no considerada en este ejercicio

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

    private Integer anonima; // 0/1

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getSolicitudId() { return solicitudId; }
    public void setSolicitudId(Integer solicitudId) { this.solicitudId = solicitudId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getRequisitosMinimos() { return requisitosMinimos; }
    public void setRequisitosMinimos(String requisitosMinimos) { this.requisitosMinimos = requisitosMinimos; }
    public Integer getAnonima() { return anonima; }
    public void setAnonima(Integer anonima) { this.anonima = anonima; }
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getLocalizacion() { return localizacion; }
    public void setLocalizacion(String localizacion) { this.localizacion = localizacion; }
    public String getSalarioModalidad() { return salarioModalidad; }
    public void setSalarioModalidad(String salarioModalidad) { this.salarioModalidad = salarioModalidad; }
    public String getSalarioMoneda() { return salarioMoneda; }
    public void setSalarioMoneda(String salarioMoneda) { this.salarioMoneda = salarioMoneda; }
    public Integer getSalarioDesde() { return salarioDesde; }
    public void setSalarioDesde(Integer salarioDesde) { this.salarioDesde = salarioDesde; }
    public Integer getSalarioHasta() { return salarioHasta; }
    public void setSalarioHasta(Integer salarioHasta) { this.salarioHasta = salarioHasta; }
    public Integer getSalarioMostrar() { return salarioMostrar; }
    public void setSalarioMostrar(Integer salarioMostrar) { this.salarioMostrar = salarioMostrar; }
}
