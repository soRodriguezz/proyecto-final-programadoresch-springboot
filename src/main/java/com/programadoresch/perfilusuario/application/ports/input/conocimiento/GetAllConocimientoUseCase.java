package com.programadoresch.perfilusuario.application.ports.input.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.commons.UseCaseWithOutInput;

import java.util.List;

public interface GetAllConocimientoUseCase extends UseCaseWithOutInput<List<Conocimiento>> {
}
