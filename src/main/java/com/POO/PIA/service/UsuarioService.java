package com.POO.PIA.service;

import com.POO.PIA.model.*;
import com.POO.PIA.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario login(String correo, String password){

        return usuarioRepository.findByCorreoAndPassword(correo, password);
    }
}