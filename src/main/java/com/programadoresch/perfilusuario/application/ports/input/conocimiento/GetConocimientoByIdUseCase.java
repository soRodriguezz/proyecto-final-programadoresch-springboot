package com.programadoresch.perfilusuario.application.ports.input.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.commons.UseCase;

public interface GetConocimientoByIdUseCase extends UseCase<Integer, Conocimiento> {
}
