package com.programadoresch.perfilusuario.application.services.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.EducacionNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.educacion.UpdateEducacionUseCase;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestEducacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateEducacionService implements UpdateEducacionUseCase {

    @Autowired
    private EducacionGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public Educacion execute(Integer idEducacion, RequestEducacionDTO dto) throws EducacionNotExistException, PerfilNotExistException {

        Educacion educacion = gateway.getEducacionById(idEducacion);

        if(educacion == null) {
            Object[] args = { idEducacion };
            throw new EducacionNotExistException("educacion.notexist.message", args);
        }

        Educacion updateEducacion = new Educacion();

        updateEducacion.setIdEducacion(idEducacion);
        updateEducacion.setInstitucion(dto.getInstitucion());
        updateEducacion.setMesInicio(dto.getMesInicio());
        updateEducacion.setAnnoInicio(dto.getAnnoInicio());
        updateEducacion.setMesFin(dto.getMesFin());
        updateEducacion.setAnnoFin(dto.getAnnoFin());
        updateEducacion.setIdPerfil(dto.getIdPerfil());

        Perfil perfil = perfilGateway.findPerfilByIdPerfil(dto.getIdPerfil());

        if(perfil == null) {
            Object[] args = { dto };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        updateEducacion.setPerfil(perfil);

        return gateway.updateEducacion(updateEducacion);

    }
}
