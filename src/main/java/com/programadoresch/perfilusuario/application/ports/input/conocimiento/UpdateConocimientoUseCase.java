package com.programadoresch.perfilusuario.application.ports.input.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.commons.UseCaseTwoInputs;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;

public interface UpdateConocimientoUseCase extends UseCaseTwoInputs<Integer, RequestConocimientoDTO, Conocimiento> {
}
