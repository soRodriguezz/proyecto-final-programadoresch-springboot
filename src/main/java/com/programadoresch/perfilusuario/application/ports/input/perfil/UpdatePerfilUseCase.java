package com.programadoresch.perfilusuario.application.ports.input.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.commons.UseCaseTwoInputs;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;

public interface UpdatePerfilUseCase extends UseCaseTwoInputs<Integer, RequestPerfilDTO, Perfil> {
}
