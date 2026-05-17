package com.POO.PIA.model;

import jakarta.persistence.*;

@Entity
@Table(name= "reviews")
public class Review {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String contenido;
    private Integer calificacion;

    @Column(name = "usuarios_id")
    private Integer usuariosId;

    @Column(name = "juegos_id")
    private Integer juegosId;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Integer usuariosId) {
        this.usuariosId = usuariosId;
    }

    public Integer getJuegosId() {
        return juegosId;
    }

    public void setJuegosId(Integer juegosId) {
        this.juegosId = juegosId;
    }


}
