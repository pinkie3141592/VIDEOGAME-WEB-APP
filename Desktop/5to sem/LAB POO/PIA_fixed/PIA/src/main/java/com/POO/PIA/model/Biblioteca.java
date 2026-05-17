package com.POO.PIA.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import java.lang.annotation.*;

@Entity
public class Biblioteca implements Serializable {
    
    @EmbeddedId
    private BibliotecaId id;

    public Biblioteca(){

    }

    public void setId(BibliotecaId id){
        this.id = id;
    }

    public BibliotecaId getId(){
        return id;
    }

}
