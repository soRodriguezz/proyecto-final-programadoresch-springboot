package com.programadoresch.perfilusuario.application.services.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado.GetLicenciaCertificadoByIdUseCase;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetLicenciaCertificadoByIdService implements GetLicenciaCertificadoByIdUseCase {
    @Autowired
    private LicenciaCertificacionGateway gateway;

    @Override
    public LicenciaCertificacion execute(Integer idLicenciaCer) {
        LicenciaCertificacion model = gateway.getLicenciaCertificacionById(idLicenciaCer);

        if(model == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return model;
    }
}
