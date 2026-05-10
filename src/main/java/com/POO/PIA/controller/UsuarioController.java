package com.POO.PIA.controller;

import com.POO.PIA.model.Usuario;
import com.POO.PIA.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    //READ ALL
    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    //CREATE
    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //DELETE
    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioRepository.deleteById(id);
    }


}
