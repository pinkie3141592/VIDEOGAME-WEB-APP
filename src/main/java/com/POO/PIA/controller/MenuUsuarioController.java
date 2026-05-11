package com.POO.PIA.controller;

import com.POO.PIA.model.Usuario;
import com.POO.PIA.model.Juego;
import com.POO.PIA.service.*;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;




public class MenuUsuarioController {

    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping("/menuUsuario")
    public String menuUsuario(HttpSession session, Model model){
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        List<Juego> juegos = bibliotecaService.obtenerJuegos(usuario.getId());
        model.addAttribute("juegos", juegos);

        return "menuUsuario";
    }



}
