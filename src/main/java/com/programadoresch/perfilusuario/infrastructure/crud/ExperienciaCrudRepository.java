package com.programadoresch.perfilusuario.infrastructure.crud;

import com.programadoresch.perfilusuario.infrastructure.models.ExperienciaDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienciaCrudRepository extends JpaRepository<ExperienciaDAO, Integer> {
    List<ExperienciaDAO> findExperienciaDAOByIdPerfil(int idPerfil);
}
