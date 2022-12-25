package com.programadoresch.perfilusuario.infrastructure.mappers;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;
import com.programadoresch.perfilusuario.infrastructure.models.PerfilDAO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PerfilMapper {
    @Mappings({
            @Mapping(source = "idPerfil", target = "idPerfil"),
            @Mapping(source = "acercaDe", target = "acercaDe"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "edad", target = "edad"),
    })
    Perfil toPerfil(PerfilDAO perfilDAO);

    List<Perfil> toPerfiles(List<PerfilDAO> daos);

    @InheritConfiguration
    PerfilDAO toPerfilDAO(Perfil dto);
}
