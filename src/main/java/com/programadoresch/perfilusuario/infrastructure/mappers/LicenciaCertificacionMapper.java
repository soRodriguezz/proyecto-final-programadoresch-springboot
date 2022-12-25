package com.programadoresch.perfilusuario.infrastructure.mappers;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.infrastructure.models.LicenciaCertificacionDAO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LicenciaCertificacionMapper {
    @Mappings({
            @Mapping(source = "idLicenciaCertificacion", target = "idLicenciaCertificacion"),
            @Mapping(source = "nombreCertificado", target = "nombreCertificado"),
            @Mapping(source = "empresaEmisora", target = "empresaEmisora"),
            @Mapping(source = "urlCertificado", target = "urlCertificado"),
            @Mapping(source = "mesInicio", target = "mesInicio"),
            @Mapping(source = "annoInicio", target = "annoInicio"),
            @Mapping(source = "mesFin", target = "mesFin"),
            @Mapping(source = "annoFin", target = "annoFin"),
            @Mapping(source = "idPerfil", target = "idPerfil"),
            @Mapping(source = "perfil", target = "perfil"),
    })
    LicenciaCertificacion toLicenciaCertificacion(LicenciaCertificacionDAO licenciaCertificacionDAO);

    List<LicenciaCertificacion> toLicenciaCertificaciones(List<LicenciaCertificacionDAO> daos);

    @InheritConfiguration
    LicenciaCertificacionDAO toLicenciaCertificacionDAO(LicenciaCertificacion licenciaCertificacion);
}
