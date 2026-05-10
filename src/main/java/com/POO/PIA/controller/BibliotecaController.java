package com.POO.PIA.controller;

import com.POO.PIA.repository.BibliotecaRepository;
import com.POO.PIA.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
    
    @Autowired
    private BibliotecaRepository repository;

    //CREATE
    @PostMapping
    public Biblioteca create(@RequestBody Biblioteca biblioteca){
        return repository.save(biblioteca);
    }


    //READ ALL
    @GetMapping
    public List<Biblioteca> getAll(){
        return repository.findAll();
    }

    //Read By ID
    @GetMapping("/{juegosId}/{usuariosId}")
    public Optional<Biblioteca> getOne(@PathVariable Long juegosId, @PathVariable Long usuariosId){
       
        BibliotecaId id = new BibliotecaId();
        id.setJuegosId(juegosId);
        id.setUsuariosId(usuariosId);

        return repository.findById(id);
    }


    //DELETE
    @DeleteMapping("/{juegosId}/{usuariosId}")
    public void delete(@PathVariable Long juegosId, @PathVariable Long usuariosId){

        BibliotecaId id = new BibliotecaId();
        id.setJuegosId(juegosId);
        id.setUsuariosId(usuariosId);

        repository.deleteById(id);

    }

}
