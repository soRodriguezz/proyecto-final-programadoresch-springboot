package com.programadoresch.perfilusuario.infrastructure.adapters.output;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.crud.PerfilCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;
import com.programadoresch.perfilusuario.infrastructure.mappers.PerfilMapper;
import com.programadoresch.perfilusuario.infrastructure.models.PerfilDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerfilRepository implements PerfilGateway {

    private final PerfilCrudRepository repository;

    private final PerfilMapper mapper;

    public PerfilRepository(PerfilCrudRepository repository, PerfilMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Perfil> getAll() {
        List<PerfilDAO> daos = repository.findAll();
        return mapper.toPerfiles(daos);
    }

    @Override
    public Perfil findPerfilByIdPerfil(int idPerfil) {
        PerfilDAO dao = repository.findPerfilByIdPerfil(idPerfil);
        return mapper.toPerfil(dao);
    }

    @Override
    public Perfil savePerfil(Perfil dto) {
        PerfilDAO dao = repository.save(mapper.toPerfilDAO(dto));
        return mapper.toPerfil(dao);
    }

    @Override
    public Perfil updatePerfil(Perfil dto) {
        PerfilDAO dao = repository.save(mapper.toPerfilDAO(dto));
        return mapper.toPerfil(dao);
    }

    @Override
    public void deletePerfil(int idPerfil) {
        repository.deleteById(idPerfil);
    }
}
