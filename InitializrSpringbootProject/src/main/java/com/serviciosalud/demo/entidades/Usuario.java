package com.serviciosalud.demo.entidades;

import com.serviciosalud.demo.enumeraciones.Roles;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private Long telefono;
    private String email;
    private String password;
    
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    
    @OneToOne
    private Image img;
    
    @Enumerated(EnumType.STRING)
    private Roles rol;
    private Boolean activo;

}