package com.programadoresch.perfilusuario.application.services.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.conocimiento.SaveConocimientoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveConocimientoService implements SaveConocimientoUseCase {
    @Autowired
    private ConocimientoGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public Conocimiento execute(RequestConocimientoDTO requestConocimientoDTO) throws PerfilNotExistException {

        Perfil perfil = perfilGateway.findPerfilByIdPerfil(requestConocimientoDTO.getIdPerfil());

        if(perfil == null) {
            Object[] args = { requestConocimientoDTO };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        Conocimiento conocimiento = new Conocimiento();

        conocimiento.setAptitud(requestConocimientoDTO.getAptitud());
        conocimiento.setIdPerfil(requestConocimientoDTO.getIdPerfil());
        conocimiento.setPerfil(perfil);

        return gateway.saveConocimiento(conocimiento);
    }
}
