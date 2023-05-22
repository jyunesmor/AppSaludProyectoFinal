package com.serviciosalud.demo.controladores;

import com.serviciosalud.demo.MiExcepcion.MiExcepcion;
import com.serviciosalud.demo.entidades.Paciente;
import com.serviciosalud.demo.servicios.PacienteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Samu Noah
 */
@Controller
@RequestMapping("/paciente")
public class PacienteResControler {

    @Autowired
    PacienteServicio pacienteServicio;

    @GetMapping("/registro")
    public String registrar() {
        
        return "/registro.html";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(@RequestParam String nombre, @RequestParam String apellido,
            @RequestParam(required = false) Integer dni, @RequestParam String email, @RequestParam(required = false) Integer telefono,
            @RequestParam String sexo, @RequestParam String password, @RequestParam String password2,
            @RequestParam String obraSocialPaciente, @RequestParam Integer numeroDeAfiliado, @RequestParam String motivoConsulta,
            ModelMap modelo) throws MiExcepcion {

        try {
            pacienteServicio.registrar(nombre, apellido, dni, email, telefono, sexo, password, password2, obraSocialPaciente,
                    numeroDeAfiliado, motivoConsulta);

            modelo.put("exito", "Usted se ha registrado correctamete");

        } catch (MiExcepcion ex) {

            modelo.put("error", ex.getMessage());
            return "registro.html";

        }
        return "index.html";
    }
    
    
    @GetMapping("/listar")
    public String listar(){
        return "listar_pacientes.html";
    }
    
    
    
    
    
    
    
    
    

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
