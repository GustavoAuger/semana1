package com.eureka6.semana1.dto;  
  
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfertaDTO {

    private Integer id;

    private Integer solicitudId; // FK pero no aplica para este caso.

    @Size(max = 200)
    private String titulo;

    @Size(max = 50)
    private String estado;

    private String descripcion;

    private String requisitosMinimos;

    private Integer anonima; 
    
    @Size(max = 50)
    private String area;

    @Size(max = 50)
    private String idioma;

    @Size(max = 50)
    private String pais;

    @Size(max = 150)
    private String localizacion;

    @Size(max = 30)
    private String salarioModalidad;

    @Size(max = 30)
    private String salarioMoneda;

    private Integer salarioDesde;

    private Integer salarioHasta;

    private Integer salarioMostrar;
}
