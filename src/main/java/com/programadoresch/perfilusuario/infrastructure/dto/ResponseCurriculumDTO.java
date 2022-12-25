package com.programadoresch.perfilusuario.infrastructure.dto;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseCurriculumDTO {
    private String acercaDe;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Conocimiento> conocimientoList;
    private List<Educacion> educacionList;
    private List<Experiencia> experienciaList;
    private List<LicenciaCertificacion> licenciaCertificacionList;
}
