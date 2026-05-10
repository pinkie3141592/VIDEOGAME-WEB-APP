package com.POO.PIA.model;

import jakarta.persistence.*;
import java.lang.annotation.*; 


@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String sede;

    @Column(name = "sitio_web")
    private String sitioWeb;

    public Publisher(){

    }

    public Integer getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSede(){
        return sede;
    }

    public String getSitioWeb(){
        return sitioWeb;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setSede(String sede){
        this.sede = sede;
    }

    public void setSitioWeb(String sitioWeb){
        this.sitioWeb = sitioWeb;
    }

    
}
