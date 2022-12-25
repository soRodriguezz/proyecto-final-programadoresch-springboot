package com.programadoresch.perfilusuario.application.ports.input.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.commons.UseCaseWithOutInput;

import java.util.List;

public interface GetAllEducacionUseCase extends UseCaseWithOutInput<List<Educacion>> {
}
