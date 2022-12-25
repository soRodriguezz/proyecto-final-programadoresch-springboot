package com.programadoresch.perfilusuario.infrastructure.crud;

import com.programadoresch.perfilusuario.infrastructure.models.EducacionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducacionCrudRepository extends JpaRepository<EducacionDAO, Integer> {
    EducacionDAO findEducacionDAOByIdEducacion(int idEducacion);

    List<EducacionDAO> findEducacionDAOByIdPerfil(int idPerfil);
}
