package com.programadoresch.perfilusuario.application.services.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.domain.exception.ConocimientoNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.conocimiento.DeleteConocimientoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteConocimientoService implements DeleteConocimientoUseCase {

    @Autowired
    private ConocimientoGateway gateway;

    @Override
    public Boolean execute(Integer idConocimiento) throws ConocimientoNotExistException {
        Conocimiento conocimiento = gateway.getConocimientoById(idConocimiento);

        if(conocimiento == null) {
            Object[] args = { idConocimiento };
            throw new ConocimientoNotExistException("conocimiento.notexist.message", args);
        }

        gateway.deleteConocimiento(idConocimiento);

        return true;
    }
}
