package com.programadoresch.perfilusuario.infrastructure.crud;

import com.programadoresch.perfilusuario.infrastructure.models.LicenciaCertificacionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenciaCertificacionCrudRepository extends JpaRepository<LicenciaCertificacionDAO, Integer> {
    List<LicenciaCertificacionDAO> findLicenciaCertificacionDAOByIdPerfil(int id);
}
