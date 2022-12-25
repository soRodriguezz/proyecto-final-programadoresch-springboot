package com.programadoresch.perfilusuario.application.ports.output.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;

import java.util.List;

public interface ExperienciaGateway {
    List<Experiencia> getAll();

    Experiencia getExperienciaById(int idExperiencia);

    List<Experiencia> findExperienciaDAOByIdPerfil(int idPerfil);

    Experiencia saveExperiencia(Experiencia experiencia);

    Experiencia updateExperiencia(Experiencia experiencia);

    void deleteExperiencia(int idExperiencia);
}
