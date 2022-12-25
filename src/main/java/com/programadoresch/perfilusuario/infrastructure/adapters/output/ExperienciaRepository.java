package com.programadoresch.perfilusuario.infrastructure.adapters.output;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import com.programadoresch.perfilusuario.infrastructure.crud.ExperienciaCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.mappers.ExperienciaMapper;
import com.programadoresch.perfilusuario.infrastructure.models.ExperienciaDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExperienciaRepository implements ExperienciaGateway {
    private final ExperienciaCrudRepository repository;

    private final ExperienciaMapper mapper;

    public ExperienciaRepository(ExperienciaCrudRepository repository, ExperienciaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Experiencia> getAll() {
        List<ExperienciaDAO> daos = repository.findAll();
        return mapper.toExperiencias(daos);
    }

    @Override
    public Experiencia getExperienciaById(int idExperiencia) {
        ExperienciaDAO dao = repository.findById(idExperiencia).get();
        return mapper.toExperiencia(dao);
    }

    @Override
    public List<Experiencia> findExperienciaDAOByIdPerfil(int idPerfil) {
        List<ExperienciaDAO> daos = repository.findExperienciaDAOByIdPerfil(idPerfil);
        return mapper.toExperiencias(daos);
    }

    @Override
    public Experiencia saveExperiencia(Experiencia experiencia) {
        ExperienciaDAO dao = repository.save(mapper.toExperienciaDAO(experiencia));
        return mapper.toExperiencia(dao);
    }

    @Override
    public Experiencia updateExperiencia(Experiencia experiencia) {
        ExperienciaDAO dao = repository.save(mapper.toExperienciaDAO(experiencia));
        return mapper.toExperiencia(dao);
    }

    @Override
    public void deleteExperiencia(int idExperiencia) {
        repository.deleteById(idExperiencia);
    }
}
