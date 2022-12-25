package com.programadoresch.perfilusuario.application.ports.input.perfil;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.commons.UseCase;

public interface GetPerfilByIdUseCase extends UseCase<Integer, Perfil> {
}
