package com.programadoresch.perfilusuario.application.services.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.ports.input.perfil.SavePerfilUseCase;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePerfilService implements SavePerfilUseCase {
    @Autowired
    private PerfilGateway gateway;

    @Override
    public Perfil execute(RequestPerfilDTO requestPerfilDTO) throws Exception {
        Perfil request = new Perfil();

        request.setIdPerfil(null);
        request.setAcercaDe(requestPerfilDTO.getAcercaDe());
        request.setNombre(requestPerfilDTO.getNombre());
        request.setApellido(requestPerfilDTO.getApellido());
        request.setEdad(requestPerfilDTO.getEdad());

        return gateway.savePerfil(request);
    }
}
