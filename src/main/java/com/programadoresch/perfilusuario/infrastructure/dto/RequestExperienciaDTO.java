package com.programadoresch.perfilusuario.infrastructure.dto;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestExperienciaDTO {
    private int idExperiencia;
    private String cargo;
    private String nombreEmpresa;
    private String ubicacion;
    private int mesInicio;
    private int annoInicio;
    private int mesFin;
    private int annoFin;
    private int idPerfil;
    private Perfil perfil;

}
