package com.programadoresch.perfilusuario.application.ports.input.licenciaCertificado;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.commons.UseCaseWithOutInput;

import java.util.List;

public interface GetAllLicenciaCertificadoUseCase extends UseCaseWithOutInput<List<LicenciaCertificacion>> {
}
