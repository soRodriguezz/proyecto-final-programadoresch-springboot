package com.programadoresch.perfilusuario.application.services.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.ports.input.experiencia.GetExperienciaByIdUseCase;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetExperienciaByIdService implements GetExperienciaByIdUseCase {
    @Autowired
    private ExperienciaGateway gateway;

    @Override
    public Experiencia execute(Integer idExperiencia) {
        Experiencia experiencia = gateway.getExperienciaById(idExperiencia);

        if(experiencia == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return experiencia;
    }
}
