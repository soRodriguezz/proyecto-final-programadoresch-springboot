package com.programadoresch.perfilusuario.application.ports.input.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.commons.UseCaseTwoInputs;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestEducacionDTO;

public interface UpdateEducacionUseCase extends UseCaseTwoInputs<Integer, RequestEducacionDTO, Educacion> {
}
