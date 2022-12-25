package com.programadoresch.perfilusuario.infrastructure.mappers;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.infrastructure.models.ExperienciaDAO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienciaMapper {
    @Mappings({
            @Mapping(source = "idExperiencia", target = "idExperiencia"),
            @Mapping(source = "cargo", target = "cargo"),
            @Mapping(source = "nombreEmpresa", target = "nombreEmpresa"),
            @Mapping(source = "ubicacion", target = "ubicacion"),
            @Mapping(source = "mesInicio", target = "mesInicio"),
            @Mapping(source = "annoInicio", target = "annoInicio"),
            @Mapping(source = "mesFin", target = "mesFin"),
            @Mapping(source = "annoFin", target = "annoFin"),
            @Mapping(source = "idPerfil", target = "idPerfil"),
            @Mapping(source = "perfil", target = "perfil"),
    })
    Experiencia toExperiencia(ExperienciaDAO dao);

    List<Experiencia> toExperiencias(List<ExperienciaDAO> daos);

    @InheritConfiguration
    ExperienciaDAO toExperienciaDAO(Experiencia experiencia);
}
