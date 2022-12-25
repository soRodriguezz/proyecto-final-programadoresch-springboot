package com.programadoresch.perfilusuario.application.services.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.perfil.UpdatePerfilUseCase;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdatePerfilService implements UpdatePerfilUseCase {
    @Autowired
    private PerfilGateway gateway;

    @Override
    public Perfil execute(Integer idPerfil, RequestPerfilDTO requestPerfilDTO) throws PerfilNotExistException {

        Perfil perfil = gateway.findPerfilByIdPerfil(idPerfil);

        if(perfil == null) {
            Object[] args = { idPerfil };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        Perfil updatePerfil = new Perfil();

        updatePerfil.setIdPerfil(idPerfil);
        updatePerfil.setAcercaDe(requestPerfilDTO.getAcercaDe());
        updatePerfil.setNombre(requestPerfilDTO.getNombre());
        updatePerfil.setApellido(requestPerfilDTO.getApellido());
        updatePerfil.setEdad(requestPerfilDTO.getEdad());

        return gateway.updatePerfil(updatePerfil);
    }

}
