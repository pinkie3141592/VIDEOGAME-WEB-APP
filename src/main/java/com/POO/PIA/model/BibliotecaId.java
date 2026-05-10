package com.POO.PIA.model;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.*;
import java.lang.annotation.*;

@Embeddable
public class BibliotecaId implements Serializable{

    private Long juegosId;
    private Long usuariosId;

    public void setJuegosId(Long juegosId){

        this.juegosId = juegosId;
    }

    public void setUsuariosId(Long usuariosId){

        this.usuariosId=usuariosId;
    }

    public Long getJuegosId(){

        return juegosId;
    }

    public Long getUsuariosId(){

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

