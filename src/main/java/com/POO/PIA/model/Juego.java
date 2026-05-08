package com.POO.PIA.model;

import jakarta.persistence.*;
import java.lang.annotation.Inherited;
import java.math.BigDecimal;

@Entity
@Table(name = "juegos")

public class Juego {

    @Id
    private Integer id;
    private String titulo;
    private BigDecimal precio;

    @Column(name = "fechaSalida")
    private String fechaSalida;
    private String descripcion;

    public Juego(){

    }
    
    public Integer getId(){
        return id;    
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
