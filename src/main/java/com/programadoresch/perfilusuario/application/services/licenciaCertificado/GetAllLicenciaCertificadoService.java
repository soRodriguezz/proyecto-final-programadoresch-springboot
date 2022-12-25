package com.programadoresch.perfilusuario.application.services.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado.GetAllLicenciaCertificadoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllLicenciaCertificadoService implements GetAllLicenciaCertificadoUseCase {
    @Autowired
    private LicenciaCertificacionGateway gateway;


    @Override
    public List<LicenciaCertificacion> execute() {
        return gateway.getAll();
    }
}
