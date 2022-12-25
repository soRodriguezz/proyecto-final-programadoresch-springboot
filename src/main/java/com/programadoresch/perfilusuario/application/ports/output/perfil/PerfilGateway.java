package com.programadoresch.perfilusuario.application.ports.output.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;

import java.util.List;

public interface PerfilGateway {
    List<Perfil> getAll();

    Perfil findPerfilByIdPerfil(int idPerfil);

    Perfil savePerfil(Perfil dto);

    Perfil updatePerfil(Perfil dto);

    void deletePerfil(int idPerfil);
}
