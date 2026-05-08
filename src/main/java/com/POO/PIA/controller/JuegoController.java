package com.POO.PIA.controller;

import com.POO.PIA.model.Juego;
import com.POO.PIA.repository.JuegoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JuegoController {

    private final JuegoRepository juegoRepository;

    public JuegoController(JuegoRepository juegoRepository){
        this.juegoRepository = juegoRepository;
    }

    @GetMapping("/juegos")
    public List<Juego> obtenerJuegos(){
        return juegoRepository.findAll();
    }


}
