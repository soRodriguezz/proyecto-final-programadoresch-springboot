package com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.commons.UseCaseTwoInputs;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestLicenciaCertificacionDTO;

public interface UpdateLicenciaCertificadoUseCase extends UseCaseTwoInputs<Integer, RequestLicenciaCertificacionDTO, LicenciaCertificacion> {
}
