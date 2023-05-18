package com.serviciosalud.demo.controladores;

import com.serviciosalud.demo.entidades.Paciente;
import com.serviciosalud.demo.entidades.Usuario;
import com.serviciosalud.demo.servicios.PacienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samu Noah
 */
@RestController
@RequestMapping("/api")
public class PacienteResControler {

    @Autowired
    PacienteServicio pacienteServicio;

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteServicio.listaPacientes());
    }
  
    @GetMapping("/pacientes2")
    public String listaPacientes() {
        pacienteServicio.crearUsuariolisto();
        return "index.html";
    }



}
