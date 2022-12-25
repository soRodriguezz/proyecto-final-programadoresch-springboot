package com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.commons.UseCase;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestLicenciaCertificacionDTO;

public interface SaveLicenciaCertificadoUseCase  extends UseCase<RequestLicenciaCertificacionDTO, LicenciaCertificacion> {
}
