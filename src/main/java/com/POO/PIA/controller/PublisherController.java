package com.POO.PIA.controller;

import com.POO.PIA.model.Publisher;
import com.POO.PIA.repository.PublisherRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }
    
    //READ ALL
    @GetMapping("/publishers")
    public List<Publisher> obtenerPublishers(){
        return publisherRepository.findAll();
    }

    //CREATE
    @PostMapping("/publishers")
    public Publisher crearPublisher(@RequestBody Publisher publisher){
        return publisherRepository.save(publisher);
    }

    //DELETE
    @DeleteMapping("/publishers/{id}")
    public void eliminarPublisher(@PathVariable Integer id){
        publisherRepository.deleteById(id);
    }



}
