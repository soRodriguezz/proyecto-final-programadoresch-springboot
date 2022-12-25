package com.programadoresch.perfilusuario.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPerfilDTO {
    private Integer idPerfil;
    private String acercaDe;
    private String nombre;
    private String apellido;
    private Integer edad;

}
