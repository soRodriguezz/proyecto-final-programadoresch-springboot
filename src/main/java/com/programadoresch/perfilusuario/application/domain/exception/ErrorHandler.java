package com.programadoresch.perfilusuario.application.domain.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class ErrorHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    public ErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(PerfilNotExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedUserException(HttpServletRequest request,
                                                                   PerfilNotExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(ConocimientoNotExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedUserException(HttpServletRequest request,
                                                                   ConocimientoNotExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(EducacionNotExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedUserException(HttpServletRequest request,
                                                                   EducacionNotExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(ExperienciaNotExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedUserException(HttpServletRequest request,
                                                                   ExperienciaNotExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(LicenciaCertificadoNotExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedUserException(HttpServletRequest request,
                                                                   LicenciaCertificadoNotExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

}
