package com.POO.PIA.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.io.Serializable;
import java.lang.annotation.Inherited;
import java.time.LocalDate;


@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rol;
    private String nombre;
    private String correo;
    private String password;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    private String pais;

    public Usuario(){

    }

    public Integer getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getPais(){
        return pais;
    }

    public LocalDate getFechaCreacion(){
        return fechaCreacion;
    }
       
    public String getPassword(){
        return password;
    }

    public String getRol(){
        return rol;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public void setFechaCreacion(LocalDate fechaCreacion){
        this.fechaCreacion = fechaCreacion; 
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public void setRol(String rol){
        this.rol = rol;
    }

}
