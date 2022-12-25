package com.programadoresch.perfilusuario.application.services.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.ConocimientoNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.conocimiento.UpdateConocimientoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateConocimientoService implements UpdateConocimientoUseCase {
    @Autowired
    private ConocimientoGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public Conocimiento execute(Integer idConocimiento, RequestConocimientoDTO dto) throws ConocimientoNotExistException, PerfilNotExistException {

        Conocimiento conocimiento = gateway.getConocimientoById(idConocimiento);
        Object[] args = { idConocimiento, dto };

        if(conocimiento == null) {
            throw new ConocimientoNotExistException("conocimiento.notexist.message", args);
        }

        Conocimiento updateConocimiento = new Conocimiento();

        updateConocimiento.setIdConocimiento(idConocimiento);
        updateConocimiento.setAptitud(dto.getAptitud());
        updateConocimiento.setIdPerfil(dto.getIdPerfil());

        Perfil perfil = perfilGateway.findPerfilByIdPerfil(dto.getIdPerfil());

        if(perfil == null) {
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        updateConocimiento.setPerfil(perfil);

        return gateway.updateConocimiento(updateConocimiento);
    }
}
