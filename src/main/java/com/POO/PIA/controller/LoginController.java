package com.POO.PIA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import com.POO.PIA.model.Usuario;
import com.POO.PIA.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(
            @RequestParam String correo,
            @RequestParam String password,
            HttpSession session
    ){

        Usuario usuario =
                usuarioService.login(correo, password);

        if(usuario == null){

            return "redirect:/login.html";
        }

        session.setAttribute("usuario", usuario);

        if(usuario.getRol().equals("ADMIN")){

            return "redirect:/menuAdministrador.html";
        }

        return "redirect:/menuUsuario.html";
    }
}