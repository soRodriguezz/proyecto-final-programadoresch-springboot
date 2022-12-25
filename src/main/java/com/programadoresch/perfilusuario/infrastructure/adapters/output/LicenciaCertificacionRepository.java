package com.programadoresch.perfilusuario.infrastructure.adapters.output;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import com.programadoresch.perfilusuario.infrastructure.crud.LicenciaCertificacionCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.mappers.LicenciaCertificacionMapper;
import com.programadoresch.perfilusuario.infrastructure.models.LicenciaCertificacionDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LicenciaCertificacionRepository implements LicenciaCertificacionGateway {

    private final LicenciaCertificacionCrudRepository repository;

    private final LicenciaCertificacionMapper mapper;

    public LicenciaCertificacionRepository(LicenciaCertificacionCrudRepository repository, LicenciaCertificacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<LicenciaCertificacion> getAll() {
        List<LicenciaCertificacionDAO> daos = repository.findAll();
        return mapper.toLicenciaCertificaciones(daos);
    }

    @Override
    public LicenciaCertificacion getLicenciaCertificacionById(int idLicenciaCertificacion) {
        LicenciaCertificacionDAO dao = repository.findById(idLicenciaCertificacion).get();
        return mapper.toLicenciaCertificacion(dao);
    }

    @Override
    public List<LicenciaCertificacion> findLicenciaCertificacionDAOByIdPerfil(int idPerfil) {
        List<LicenciaCertificacionDAO> daos = repository.findLicenciaCertificacionDAOByIdPerfil(idPerfil);
        return mapper.toLicenciaCertificaciones(daos);
    }

    @Override
    public LicenciaCertificacion saveLicenciaCertificacion(LicenciaCertificacion licenciaCertificacion) {
        LicenciaCertificacionDAO dao = repository.save(mapper.toLicenciaCertificacionDAO(licenciaCertificacion));
        return mapper.toLicenciaCertificacion(dao);
    }

    @Override
    public LicenciaCertificacion updateLicenciaCertificacion(LicenciaCertificacion licenciaCertificacion) {
        LicenciaCertificacionDAO dao = repository.save(mapper.toLicenciaCertificacionDAO(licenciaCertificacion));
        return mapper.toLicenciaCertificacion(dao);
    }

    @Override
    public void deleteLicenciaCertificacion(int idLicenciaCertificacion) {
        repository.deleteById(idLicenciaCertificacion);
    }
}
