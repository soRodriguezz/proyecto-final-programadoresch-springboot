package com.programadoresch.perfilusuario.infrastructure.mappers;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.infrastructure.models.EducacionDAO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducacionMapper {
    @Mappings({
            @Mapping(source = "idEducacion", target = "idEducacion"),
            @Mapping(source = "institucion", target = "institucion"),
            @Mapping(source = "mesInicio", target = "mesInicio"),
            @Mapping(source = "annoInicio", target = "annoInicio"),
            @Mapping(source = "mesFin", target = "mesFin"),
            @Mapping(source = "annoFin", target = "annoFin"),
            @Mapping(source = "idPerfil", target = "idPerfil"),
            @Mapping(source = "perfil", target = "perfil")
    })
    Educacion toEducacion(EducacionDAO educacionDAO);

    List<Educacion> toEducaciones(List<EducacionDAO> daos);

    @InheritConfiguration
    EducacionDAO toEducacionDAO(Educacion educacion);
}
