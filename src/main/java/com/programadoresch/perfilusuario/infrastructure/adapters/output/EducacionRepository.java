package com.programadoresch.perfilusuario.infrastructure.adapters.output;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import com.programadoresch.perfilusuario.infrastructure.crud.EducacionCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.mappers.EducacionMapper;
import com.programadoresch.perfilusuario.infrastructure.models.EducacionDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EducacionRepository implements EducacionGateway {
    private final EducacionCrudRepository repository;

    private final EducacionMapper mapper;

    public EducacionRepository(EducacionCrudRepository repository, EducacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Educacion> getAll() {
        List<EducacionDAO> daos = repository.findAll();
        return mapper.toEducaciones(daos);
    }

    @Override
    public List<Educacion> findEducacionDAOByIdPerfil(int id) {
        List<EducacionDAO> daos = repository.findEducacionDAOByIdPerfil(id);
        return mapper.toEducaciones(daos);
    }

    @Override
    public Educacion getEducacionById(int idEducacion) {
        EducacionDAO dao = repository.findEducacionDAOByIdEducacion(idEducacion);
        return mapper.toEducacion(dao);
    }

    @Override
    public Educacion saveEducacion(Educacion educacion) {
        EducacionDAO dao = repository.save(mapper.toEducacionDAO(educacion));
        return mapper.toEducacion(dao);
    }

    @Override
    public Educacion updateEducacion(Educacion educacion) {
        EducacionDAO dao = repository.save(mapper.toEducacionDAO(educacion));
        return mapper.toEducacion(dao);
    }

    @Override
    public void deleteEducacion(int idEducacion) {
        repository.deleteById(idEducacion);
    }
}
