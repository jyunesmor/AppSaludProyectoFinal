package com.serviciosalud.demo.controladores;

import com.serviciosalud.demo.MiExcepcion.MiExcepcion;
import com.serviciosalud.demo.servicios.ProfesionalServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

    @Autowired
    public ProfesionalServicio profesionalServicio;

    @GetMapping("/dashboard")
    public String panelAdminstrativo() {
        return "panel.html";
    }

    @GetMapping("/registrar-profesional")
    public String registrarProfesional() {
        return "registro_profesional.html";
    }

    @PostMapping("/registro-profesional")
    public String registroProfesional(@RequestParam String nombre, @RequestParam String apellido,
            @RequestParam(required = false) Integer dni, @RequestParam String email, @RequestParam(required = false) Integer telefono,
            @RequestParam String sexo, @RequestParam String password, @RequestParam String password2, @RequestParam Long matricula,
            @RequestParam String especialidad, @RequestParam Double precio, @RequestParam Double calificacion, @RequestParam String localidad, 
            @RequestParam String obraSocial,@RequestParam Long telefonoLaboral, @RequestParam String descripcion,
            @RequestParam String nombreEstablecimiento, ModelMap modelo) {

        
        try {
            profesionalServicio.registrar(nombre, apellido, dni, email, telefono, sexo, password, password2,
                    matricula, especialidad, precio, calificacion, localidad, obraSocial, telefonoLaboral, descripcion,
                    nombreEstablecimiento);

            modelo.put("exito", "Usted se ha registrado correctamete");

        } catch (MiExcepcion ex) {
            modelo.put("error", ex.getMessage());
            return "registro_profesional.html";

        }

        return "panel.html";
    }

}
