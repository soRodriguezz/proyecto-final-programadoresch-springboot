package com.programadoresch.perfilusuario.application.ports.input.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.commons.UseCaseWithOutInput;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;

import java.util.List;

public interface GetAllPerfilUseCase extends UseCaseWithOutInput<List<Perfil>> {
}
