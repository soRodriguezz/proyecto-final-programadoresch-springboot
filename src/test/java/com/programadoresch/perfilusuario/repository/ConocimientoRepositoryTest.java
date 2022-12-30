package com.programadoresch.perfilusuario.repository;

import com.programadoresch.perfilusuario.infrastructure.crud.ConocimientoCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.crud.PerfilCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.models.ConocomientoDAO;
import com.programadoresch.perfilusuario.infrastructure.models.PerfilDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ConocimientoRepositoryTest {
    @Autowired
    private ConocimientoCrudRepository repository;
    @Autowired
    private PerfilCrudRepository perfilCrudRepository;
    ConocomientoDAO conocimiento = new ConocomientoDAO();
    List<ConocomientoDAO> conocomientoList = new ArrayList<>();
    PerfilDAO perfil = new PerfilDAO();

    @BeforeEach
    void setUp() {
        perfil.setAcercaDe("acercade1");
        perfil.setNombre("nombre1");
        perfil.setApellido("apellido1");
        perfil.setEdad(23);

        perfilCrudRepository.save(perfil);

        conocimiento.setAptitud("aptitud");
        conocimiento.setIdPerfil(1);
        conocimiento.setPerfil(perfil);

        conocomientoList.add(conocimiento);

        repository.save(conocimiento);
    }

    @AfterEach
    void tearDown() {
        conocimiento = null;
        repository.deleteAll();
    }

    @Test
    void testFindByIdConocimiento() {
        ConocomientoDAO conocomientoDAOList = repository.findConocomientoDAOByIdConocimiento(1);
        assertThat(conocomientoDAOList).isEqualTo(conocimiento);
    }

    @Test
    void testFindConocomientoByIdPerfil() {
        List<ConocomientoDAO> conocomientoDAOList = repository.findConocomientoDAOByIdPerfil(1);
        assertThat(conocomientoDAOList).isEqualTo(conocomientoList);
    }

}
