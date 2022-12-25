package com.programadoresch.perfilusuario.application.services.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.ports.input.perfil.GetAllPerfilUseCase;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPerfilService implements GetAllPerfilUseCase {
    @Autowired
    private PerfilGateway gateway;

    @Override
    public List<Perfil> execute() {
        return gateway.getAll();
    }
}
