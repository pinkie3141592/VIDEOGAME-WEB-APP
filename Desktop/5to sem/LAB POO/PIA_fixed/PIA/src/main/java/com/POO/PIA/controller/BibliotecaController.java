package com.POO.PIA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.POO.PIA.model.Biblioteca;
import com.POO.PIA.model.Juego;
import com.POO.PIA.model.BibliotecaId;

import com.POO.PIA.repository.BibliotecaRepository;

import com.POO.PIA.service.BibliotecaService;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    BibliotecaService bibliotecaService;

    @Autowired
    private BibliotecaRepository repository;

    //crear la relacion entre un usuario y sus juegos
    @PostMapping
    public Biblioteca create(@RequestBody Biblioteca biblioteca){
        return repository.save(biblioteca);
    }

    //obtener todas las bibliotecas
    @GetMapping
    public List<Biblioteca> getAll(){
        return repository.findAll();
    }

    //confirmar q un usuario tiene un juego
    @GetMapping("/{juegosId}/{usuariosId}")
    public Optional<Biblioteca> getOne(
        @PathVariable Integer juegosId,
        @PathVariable Integer usuariosId){

        BibliotecaId id = new BibliotecaId();

        id.setJuegosId(juegosId);
        id.setUsuariosId(usuariosId);

        return repository.findById(id);
    }

    // eliminar el juego de un usuario
    @DeleteMapping("/{juegosId}/{usuariosId}")
    public void delete(
        @PathVariable Integer juegosId,
        @PathVariable Integer usuariosId){

        BibliotecaId id = new BibliotecaId();

        id.setJuegosId(juegosId);
        id.setUsuariosId(usuariosId);

        repository.deleteById(id);
    }

    //encontrar biblioteca de un usuario 
    @GetMapping("/usuario/{id}")
    public List<Juego> obtenerJuegosUsuario(@PathVariable Integer id){

        return bibliotecaService.obtenerJuegos(id);
    }
}