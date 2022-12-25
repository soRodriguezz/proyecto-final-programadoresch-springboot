package com.programadoresch.perfilusuario.application.services.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.ports.input.educacion.GetAllEducacionUseCase;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEducacionService implements GetAllEducacionUseCase {
    @Autowired
    private EducacionGateway gateway;

    @Override
    public List<Educacion> execute() {
        return gateway.getAll();
    }
}
