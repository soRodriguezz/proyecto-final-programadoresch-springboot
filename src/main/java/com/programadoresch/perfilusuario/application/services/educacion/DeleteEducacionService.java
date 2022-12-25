package com.programadoresch.perfilusuario.application.services.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.domain.exception.EducacionNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.educacion.DeleteEducacionUseCase;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteEducacionService implements DeleteEducacionUseCase {
    @Autowired
    private EducacionGateway gateway;

    @Override
    public Boolean execute(Integer idEducacion) throws EducacionNotExistException {
        Educacion educacion = gateway.getEducacionById(idEducacion);

        if(educacion == null) {
            Object[] args = { idEducacion };
            throw new EducacionNotExistException("educacion.notexist.message", args);
        }

        gateway.deleteEducacion(idEducacion);

        return true;
    }
}
