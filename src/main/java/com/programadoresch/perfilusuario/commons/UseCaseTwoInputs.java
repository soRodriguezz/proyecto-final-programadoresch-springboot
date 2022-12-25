package com.programadoresch.perfilusuario.commons;

import com.programadoresch.perfilusuario.application.domain.exception.*;

public interface UseCaseTwoInputs<Input, Input2, Output> {
    Output execute(Input input, Input2 input2) throws PerfilNotExistException, ConocimientoNotExistException, EducacionNotExistException, ExperienciaNotExistException, LicenciaCertificadoNotExistException;
}
