package com.programadoresch.perfilusuario.application.ports.output.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;

import java.util.List;

public interface EducacionGateway {
    List<Educacion> getAll();

    List<Educacion> findEducacionDAOByIdPerfil(int idPerfil);

    Educacion getEducacionById(int idEducacion);

    Educacion saveEducacion(Educacion educacion);

    Educacion updateEducacion(Educacion educacion);

    void deleteEducacion(int idEducacion);
}
