package com.POO.PIA.controller;

import com.POO.PIA.model.Juego;
import com.POO.PIA.repository.JuegoRepository;

import org.springframework.web.bind.annotation.*;
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
    
    @GetMapping("/juegos/{id}")
    public Juego obtenerJuego(@PathVariable Integer id){
        return juegoRepository.findById(id).orElse(null);
    }


}
