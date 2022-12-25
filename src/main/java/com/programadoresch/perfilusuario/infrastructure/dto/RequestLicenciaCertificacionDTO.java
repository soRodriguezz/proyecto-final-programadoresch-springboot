package com.programadoresch.perfilusuario.infrastructure.dto;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLicenciaCertificacionDTO {
    private int idLicenciaCertificacion;
    private String nombreCertificado;
    private String empresaEmisora;
    private String urlCertificado;
    private int mesInicio;
    private int annoInicio;
    private int mesFin;
    private int annoFin;
    private int idPerfil;
    private Perfil perfil;

}
