package com.programadoresch.perfilusuario.infrastructure.mappers;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;
import com.programadoresch.perfilusuario.infrastructure.models.ConocomientoDAO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConocimientoMapper {
    @Mappings({
            @Mapping(source = "idConocimiento", target = "idConocimiento"),
            @Mapping(source = "aptitud", target = "aptitud"),
            @Mapping(source = "idPerfil", target = "idPerfil"),
            @Mapping(source = "perfil", target = "perfil")
    })
    Conocimiento toConocimiento(ConocomientoDAO dao);

    List<Conocimiento> toConocimientos(List<ConocomientoDAO> daos);

    @InheritConfiguration
    ConocomientoDAO toConocimientoDAO(Conocimiento dto);
}
