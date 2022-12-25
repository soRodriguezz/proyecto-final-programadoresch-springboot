package com.programadoresch.perfilusuario.application.services.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.ports.input.conocimiento.GetConocimientoByIdUseCase;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetConocimientoByIdService implements GetConocimientoByIdUseCase {

    @Autowired
    private ConocimientoGateway gateway;

    @Override
    public Conocimiento execute(Integer idConocimiento) {

        Conocimiento conocimiento = gateway.getConocimientoById(idConocimiento);

        if(conocimiento == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return conocimiento;
    }
}
