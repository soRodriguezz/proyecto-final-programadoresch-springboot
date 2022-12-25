package com.programadoresch.perfilusuario.application.services.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.domain.exception.LicenciaCertificadoNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.experiencia.DeleteExperienciaUseCase;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DeleteLicenciaCertificadoService implements DeleteExperienciaUseCase {

    @Autowired
    private LicenciaCertificacionGateway gateway;

    @Override
    public Boolean execute(Integer id) throws LicenciaCertificadoNotExistException {
        LicenciaCertificacion licenciaCert = gateway.getLicenciaCertificacionById(id);

        if (licenciaCert == null) {
            Object[] args = { id };
            throw new LicenciaCertificadoNotExistException("licenciacertificacion.notexist.message", args);
        }

        gateway.deleteLicenciaCertificacion(id);

        return true;
    }
}
