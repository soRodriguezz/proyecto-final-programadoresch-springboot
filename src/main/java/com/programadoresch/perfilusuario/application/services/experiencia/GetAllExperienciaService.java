package com.programadoresch.perfilusuario.application.services.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.ports.input.experiencia.GetAllExperienciaUseCase;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllExperienciaService implements GetAllExperienciaUseCase {
    @Autowired
    private ExperienciaGateway gateway;

    @Override
    public List<Experiencia> execute() {
        return gateway.getAll();
    }
}
