package com.POO.PIA.repository;

import com.POO.PIA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByNombre(String nombre);
    Usuario findByCorreoAndPassword(String correo, String password);
    Usuario findByCorreo(String correo);
}
