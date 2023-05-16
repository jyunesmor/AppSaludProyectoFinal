
package com.serviciosalud.demo.repositorios;

import com.serviciosalud.demo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Samu Noah
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {
    
    
   
   
}