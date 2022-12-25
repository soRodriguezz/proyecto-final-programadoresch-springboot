package com.programadoresch.perfilusuario.application.ports.input.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.commons.UseCaseWithOutInput;

import java.util.List;

public interface GetAllExperienciaUseCase extends UseCaseWithOutInput<List<Experiencia>> {
}
