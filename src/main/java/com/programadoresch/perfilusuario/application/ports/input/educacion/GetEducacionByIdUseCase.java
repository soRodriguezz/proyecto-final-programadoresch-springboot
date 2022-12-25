package com.programadoresch.perfilusuario.application.ports.input.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.commons.UseCase;

public interface GetEducacionByIdUseCase extends UseCase<Integer, Educacion> {
}
