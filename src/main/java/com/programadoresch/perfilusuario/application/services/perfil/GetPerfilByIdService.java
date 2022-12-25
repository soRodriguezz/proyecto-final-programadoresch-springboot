package com.programadoresch.perfilusuario.application.services.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.ports.input.perfil.GetPerfilByIdUseCase;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetPerfilByIdService implements GetPerfilByIdUseCase {
    @Autowired
    private PerfilGateway gateway;

    @Override
    public Perfil execute(Integer idPerfil) throws Exception {

        Perfil perfil = gateway.findPerfilByIdPerfil(idPerfil);

        if(perfil == null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return perfil;
    }
}
