package com.serviciosalud.demo.entidades;

import com.serviciosalud.demo.enumeraciones.Especialidad;
import com.serviciosalud.demo.enumeraciones.Modalidad;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Profesional extends Usuario{
        
    private Long matricula;
    private Especialidad especialidad;
    private Modalidad modalidad;
    private Double precio;
    private Double calificacion;
    private String localidad;
}
