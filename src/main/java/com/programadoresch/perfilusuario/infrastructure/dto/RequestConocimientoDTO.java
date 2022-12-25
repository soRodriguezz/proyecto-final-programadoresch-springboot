package com.programadoresch.perfilusuario.infrastructure.dto;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestConocimientoDTO {
    private int idConocimiento;
    private String aptitud;
    private int idPerfil;
    private Perfil perfil;
}
