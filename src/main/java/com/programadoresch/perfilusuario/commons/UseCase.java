package com.programadoresch.perfilusuario.commons;

public interface UseCase<Input, Output> {

    Output execute(Input input) throws Exception;

}
