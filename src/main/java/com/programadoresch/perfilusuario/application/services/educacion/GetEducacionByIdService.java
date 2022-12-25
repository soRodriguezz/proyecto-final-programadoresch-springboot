package com.programadoresch.perfilusuario.application.services.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.ports.input.educacion.GetEducacionByIdUseCase;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetEducacionByIdService implements GetEducacionByIdUseCase {

    @Autowired
    private EducacionGateway gateway;

    @Override
    public Educacion execute(Integer idEducacion) {

        Educacion educacion = gateway.getEducacionById(idEducacion);

        if (educacion == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return educacion;
    }
}
