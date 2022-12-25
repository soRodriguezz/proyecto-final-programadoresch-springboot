package com.programadoresch.perfilusuario.application.domain.exception;

public class EducacionNotExistException extends Exception {
    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public EducacionNotExistException(String name) {
        this.message = String.format("There is already a pet with the name - %s", name);
    }

    public EducacionNotExistException(Object[] args) {
        this.args = args;
    }

    public EducacionNotExistException(String message, Object[] args) {
        this.message = message;
        this.args = args;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
