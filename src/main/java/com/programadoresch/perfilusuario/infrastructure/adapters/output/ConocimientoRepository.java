package com.programadoresch.perfilusuario.infrastructure.adapters.output;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import com.programadoresch.perfilusuario.infrastructure.crud.ConocimientoCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;
import com.programadoresch.perfilusuario.infrastructure.mappers.ConocimientoMapper;
import com.programadoresch.perfilusuario.infrastructure.models.ConocomientoDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConocimientoRepository implements ConocimientoGateway {

    private final ConocimientoCrudRepository repository;

    private final ConocimientoMapper mapper;

    public ConocimientoRepository(ConocimientoCrudRepository repository, ConocimientoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Conocimiento> getAll() {
        List<ConocomientoDAO> daos = repository.findAll();
        return mapper.toConocimientos(daos);
    }

    @Override
    public Conocimiento getConocimientoById(int idConocimiento) {
        ConocomientoDAO dao = repository.findConocomientoDAOByIdConocimiento(idConocimiento);
        return mapper.toConocimiento(dao);
    }

    @Override
    public List<Conocimiento> findConocomientoDAOByIdPerfil(int idPerfil) {
        List<ConocomientoDAO> daos = repository.findConocomientoDAOByIdPerfil(idPerfil);
        return mapper.toConocimientos(daos);
    }

    @Override
    public Conocimiento saveConocimiento(Conocimiento dto) {
        ConocomientoDAO dao = repository.save(mapper.toConocimientoDAO(dto));
        return mapper.toConocimiento(dao);
    }

    @Override
    public Conocimiento updateConocimiento(Conocimiento dto) {
        ConocomientoDAO dao = repository.save(mapper.toConocimientoDAO(dto));
        return mapper.toConocimiento(dao);
    }

    @Override
    public void deleteConocimiento(int idConocimiento) {
        repository.deleteById(idConocimiento);
    }

}
