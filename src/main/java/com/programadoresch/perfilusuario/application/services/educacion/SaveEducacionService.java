package com.programadoresch.perfilusuario.application.services.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.educacion.SaveEducacionUseCase;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestEducacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SaveEducacionService implements SaveEducacionUseCase {

    @Autowired
    private EducacionGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public Educacion execute(RequestEducacionDTO requestEducacionDTO) throws PerfilNotExistException {
        Perfil perfil = perfilGateway.findPerfilByIdPerfil(requestEducacionDTO.getIdPerfil());

        if(perfil == null) {
            Object[] args = { requestEducacionDTO };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        Educacion educacion = new Educacion();

        educacion.setInstitucion(requestEducacionDTO.getInstitucion());
        educacion.setMesInicio(requestEducacionDTO.getMesInicio());
        educacion.setAnnoInicio(requestEducacionDTO.getAnnoInicio());
        educacion.setMesFin(requestEducacionDTO.getMesFin());
        educacion.setAnnoFin(requestEducacionDTO.getAnnoFin());
        educacion.setIdPerfil(requestEducacionDTO.getIdPerfil());
        educacion.setPerfil(perfil);

        return gateway.saveEducacion(educacion);

    }
}
