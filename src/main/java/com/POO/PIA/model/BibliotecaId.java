package com.POO.PIA.model;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.*;
import java.lang.annotation.*;

@Embeddable
public class BibliotecaId implements Serializable{

    private Integer juegosId;
    private Integer usuariosId;

    public void setJuegosId(Integer juegosId){

        this.juegosId = juegosId;
    }

    public void setUsuariosId(Integer usuariosId){

        this.usuariosId=usuariosId;
    }

    public Integer getJuegosId(){

        return juegosId;
    }

    public Integer getUsuariosId(){

        return usuariosId;
    }

    @Override
    public boolean equals(Object o){

        if(this == o)
            return true;

        if(!(o instanceof BibliotecaId))
            return false;

        BibliotecaId that = (BibliotecaId) o;

        return Objects.equals(juegosId, that.juegosId) &&
            Objects.equals(usuariosId, that.usuariosId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(juegosId, usuariosId);
    }

}

