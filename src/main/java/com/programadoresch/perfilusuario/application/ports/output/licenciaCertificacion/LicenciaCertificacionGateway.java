package com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;

import java.util.List;

public interface LicenciaCertificacionGateway {
    List<LicenciaCertificacion> getAll();

    LicenciaCertificacion getLicenciaCertificacionById(int idLicenciaCertificacion);

    List<LicenciaCertificacion> findLicenciaCertificacionDAOByIdPerfil(int idPerfil);

    LicenciaCertificacion saveLicenciaCertificacion(LicenciaCertificacion licenciaCertificacion);

    LicenciaCertificacion updateLicenciaCertificacion(LicenciaCertificacion licenciaCertificacion);

    void deleteLicenciaCertificacion(int idLicenciaCertificacion);
}
