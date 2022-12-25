package com.programadoresch.perfilusuario.application.services.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.experiencia.SaveExperienciaUseCase;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestExperienciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SaveExperienciaService implements SaveExperienciaUseCase {
    @Autowired
    private ExperienciaGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public Experiencia execute(RequestExperienciaDTO requestExperienciaDTO) throws PerfilNotExistException {
        Perfil perfil = perfilGateway.findPerfilByIdPerfil(requestExperienciaDTO.getIdPerfil());

        if(perfil == null) {
            Object[] args = { requestExperienciaDTO };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        Experiencia experiencia = new Experiencia();

        experiencia.setCargo(requestExperienciaDTO.getCargo());
        experiencia.setNombreEmpresa(requestExperienciaDTO.getNombreEmpresa());
        experiencia.setUbicacion(requestExperienciaDTO.getUbicacion());
        experiencia.setMesInicio(requestExperienciaDTO.getMesInicio());
        experiencia.setAnnoInicio(requestExperienciaDTO.getAnnoInicio());
        experiencia.setMesFin(requestExperienciaDTO.getMesFin());
        experiencia.setAnnoFin(requestExperienciaDTO.getAnnoFin());
        experiencia.setIdPerfil(requestExperienciaDTO.getIdPerfil());
        experiencia.setPerfil(perfil);

        return gateway.saveExperiencia(experiencia);
    }
}
