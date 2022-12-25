package com.programadoresch.perfilusuario.application.ports.input.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.commons.UseCase;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;

public interface SaveConocimientoUseCase extends UseCase<RequestConocimientoDTO, Conocimiento> {
}
