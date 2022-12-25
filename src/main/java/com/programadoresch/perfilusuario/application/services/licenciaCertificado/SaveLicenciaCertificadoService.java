package com.programadoresch.perfilusuario.application.services.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado.SaveLicenciaCertificadoUseCase;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestLicenciaCertificacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SaveLicenciaCertificadoService implements SaveLicenciaCertificadoUseCase {
    @Autowired
    private LicenciaCertificacionGateway gateway;
    @Autowired
    private PerfilGateway perfilGateway;

    @Override
    public LicenciaCertificacion execute(RequestLicenciaCertificacionDTO dto) throws PerfilNotExistException {
        Perfil perfil = perfilGateway.findPerfilByIdPerfil(dto.getIdPerfil());

        if(perfil == null) {
            Object[] args = { dto };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        LicenciaCertificacion save = new LicenciaCertificacion();

        save.setNombreCertificado(dto.getNombreCertificado());
        save.setEmpresaEmisora(dto.getEmpresaEmisora());
        save.setUrlCertificado(dto.getUrlCertificado());
        save.setMesInicio(dto.getMesInicio());
        save.setAnnoInicio(dto.getAnnoInicio());
        save.setMesFin(dto.getMesFin());
        save.setAnnoFin(dto.getAnnoFin());
        save.setIdPerfil(dto.getIdPerfil());
        save.setPerfil(perfil);

        return gateway.saveLicenciaCertificacion(save);
    }
}
