package com.POO.PIA.controller;

import com.POO.PIA.model.Juego;
import com.POO.PIA.repository.JuegoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/juegos")
    public Juego crearJuego(@RequestBody Juego juego){
        return juegoRepository.save(juego);
    }

    @DeleteMapping("/juegos/{id}")
    public void eliminarJuego(@PathVariable Integer id){
        juegoRepository.deleteById(id);
    }


}
