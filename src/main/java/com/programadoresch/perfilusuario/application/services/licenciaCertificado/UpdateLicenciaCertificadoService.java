package com.programadoresch.perfilusuario.application.services.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.LicenciaCertificadoNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado.UpdateLicenciaCertificadoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestLicenciaCertificacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UpdateLicenciaCertificadoService implements UpdateLicenciaCertificadoUseCase {

    @Autowired
    private LicenciaCertificacionGateway gateway;

    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public LicenciaCertificacion execute(Integer id, RequestLicenciaCertificacionDTO dto) throws PerfilNotExistException, LicenciaCertificadoNotExistException {
        LicenciaCertificacion licenciaCert = gateway.getLicenciaCertificacionById(id);

        Object[] args = { id, dto };

        if(licenciaCert == null) {
            throw new LicenciaCertificadoNotExistException("licenciacertificacion.notexist.message", args);
        }

        LicenciaCertificacion model = new LicenciaCertificacion();

        model.setIdLicenciaCertificacion(id);
        model.setNombreCertificado(dto.getNombreCertificado());
        model.setEmpresaEmisora(dto.getEmpresaEmisora());
        model.setUrlCertificado(dto.getUrlCertificado());
        model.setMesInicio(dto.getMesInicio());
        model.setAnnoInicio(dto.getAnnoInicio());
        model.setMesFin(dto.getMesFin());
        model.setAnnoFin(dto.getAnnoFin());
        model.setIdPerfil(dto.getIdPerfil());

        Perfil perfil = perfilGateway.findPerfilByIdPerfil(dto.getIdPerfil());

        if(perfil == null) {
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        model.setPerfil(perfil);

        return gateway.updateLicenciaCertificacion(model);
    }
}
