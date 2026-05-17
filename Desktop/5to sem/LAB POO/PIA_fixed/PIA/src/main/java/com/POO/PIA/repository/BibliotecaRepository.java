package com.POO.PIA.repository;

import com.POO.PIA.model.*;
import com.POO.PIA.service.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, BibliotecaId>{
    @Query("""
        SELECT j
        FROM Juego j, Biblioteca b
        WHERE j.id = b.id.juegosId
        AND b.id.usuariosId = :usuarioId
    """)
    List<Juego> obtenerJuegosUsuario(@Param("usuarioId") Integer usuarioId);
}
