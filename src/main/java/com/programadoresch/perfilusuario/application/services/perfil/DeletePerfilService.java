package com.programadoresch.perfilusuario.application.services.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.perfil.DeletePerfilUseCase;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeletePerfilService implements DeletePerfilUseCase {

    @Autowired
    private PerfilGateway gateway;

    @Override
    public Boolean execute(Integer idPerfil) throws PerfilNotExistException {
        Perfil perfil = gateway.findPerfilByIdPerfil(idPerfil);

        if( perfil == null ) {
            Object[] args = { idPerfil };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        gateway.deletePerfil(idPerfil);

        return true;
    }
}
