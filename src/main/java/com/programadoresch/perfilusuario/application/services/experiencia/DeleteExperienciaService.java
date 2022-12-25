package com.programadoresch.perfilusuario.application.services.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.domain.exception.ExperienciaNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.experiencia.DeleteExperienciaUseCase;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteExperienciaService implements DeleteExperienciaUseCase {
    @Autowired
    private ExperienciaGateway gateway;

    @Override
    public Boolean execute(Integer idExperiencia) throws ExperienciaNotExistException {
        Experiencia experiencia = gateway.getExperienciaById(idExperiencia);

        if (experiencia == null){
            Object[] args = { idExperiencia };
            throw new ExperienciaNotExistException("experiencia.notexist.message", args);
        }

        gateway.deleteExperiencia(idExperiencia);

        return true;
    }
}
