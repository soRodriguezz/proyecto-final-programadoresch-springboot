package com.programadoresch.perfilusuario.application.ports.input.educacion;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.commons.UseCase;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestEducacionDTO;

public interface SaveEducacionUseCase extends UseCase<RequestEducacionDTO, Educacion> {
}
