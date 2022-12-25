package com.programadoresch.perfilusuario.application.ports.input.experiencia;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.commons.UseCase;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestExperienciaDTO;

public interface SaveExperienciaUseCase extends UseCase<RequestExperienciaDTO, Experiencia> {
}
