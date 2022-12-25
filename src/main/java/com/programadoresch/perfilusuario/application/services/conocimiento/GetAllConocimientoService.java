package com.programadoresch.perfilusuario.application.services.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.ports.input.conocimiento.GetAllConocimientoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllConocimientoService implements GetAllConocimientoUseCase {
    @Autowired
    private ConocimientoGateway gateway;

    @Override
    public List<Conocimiento> execute() {
        return gateway.getAll();
    }
}
