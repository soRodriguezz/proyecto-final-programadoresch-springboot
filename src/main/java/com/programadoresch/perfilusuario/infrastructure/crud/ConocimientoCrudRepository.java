package com.programadoresch.perfilusuario.infrastructure.crud;

import com.programadoresch.perfilusuario.infrastructure.models.ConocomientoDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConocimientoCrudRepository extends JpaRepository<ConocomientoDAO, Integer> {

    ConocomientoDAO findConocomientoDAOByIdConocimiento(int id);

    List<ConocomientoDAO> findConocomientoDAOByIdPerfil(int id);

}
