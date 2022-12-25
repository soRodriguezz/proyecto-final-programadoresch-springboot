package com.programadoresch.perfilusuario.infrastructure.crud;

import com.programadoresch.perfilusuario.infrastructure.models.PerfilDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilCrudRepository extends JpaRepository<PerfilDAO, Integer> {

    PerfilDAO findPerfilByIdPerfil(int idPerfil);
}
