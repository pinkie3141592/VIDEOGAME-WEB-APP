package com.POO.PIA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import com.POO.PIA.model.Usuario;
import com.POO.PIA.repository.UsuarioRepository;
import com.POO.PIA.service.UsuarioService;

@RestController
public class LoginController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario datos){

        return usuarioRepository.findByCorreoAndPassword(
            datos.getCorreo(),
            datos.getPassword()
        );
    }
}