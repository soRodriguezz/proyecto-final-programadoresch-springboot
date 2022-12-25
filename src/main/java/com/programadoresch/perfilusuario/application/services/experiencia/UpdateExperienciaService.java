package com.programadoresch.perfilusuario.application.services.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.ExperienciaNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.experiencia.UpdateExperienciaUseCase;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestExperienciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateExperienciaService implements UpdateExperienciaUseCase {

    @Autowired
    private ExperienciaGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public Experiencia execute(Integer idExperiencia, RequestExperienciaDTO dto) throws PerfilNotExistException, ExperienciaNotExistException {
        Experiencia experiencia = gateway.getExperienciaById(idExperiencia);
        Object[] args = { idExperiencia, dto };

        if(experiencia == null) {
            throw new ExperienciaNotExistException("experiencia.notexist.message", args);
        }

        Experiencia updateExperiencia = new Experiencia();

        updateExperiencia.setIdExperiencia(idExperiencia);
        updateExperiencia.setCargo(dto.getCargo());
        updateExperiencia.setNombreEmpresa(dto.getNombreEmpresa());
        updateExperiencia.setUbicacion(dto.getUbicacion());
        updateExperiencia.setMesInicio(dto.getMesInicio());
        updateExperiencia.setAnnoInicio(dto.getAnnoInicio());
        updateExperiencia.setMesFin(dto.getMesFin());
        updateExperiencia.setAnnoFin(dto.getAnnoFin());
        updateExperiencia.setIdPerfil(dto.getIdPerfil());

        Perfil perfil = perfilGateway.findPerfilByIdPerfil(dto.getIdPerfil());

        if(perfil == null) {
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        updateExperiencia.setPerfil(perfil);

        return gateway.updateExperiencia(updateExperiencia);

    }
}
