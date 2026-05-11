package com.POO.PIA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.POO.PIA.model.Juego;
import com.POO.PIA.repository.BibliotecaRepository;


@Service
public class BibliotecaService {

    @Autowired
    BibliotecaRepository bibliotecaRepository;

    public List<Juego> obtenerJuegos(Integer usuarioId){

        return bibliotecaRepository.obtenerJuegosUsuario(usuarioId);
    }
}