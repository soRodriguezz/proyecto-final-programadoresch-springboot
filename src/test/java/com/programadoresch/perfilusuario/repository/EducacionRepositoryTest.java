package com.programadoresch.perfilusuario.repository;

import com.programadoresch.perfilusuario.infrastructure.crud.EducacionCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.crud.PerfilCrudRepository;
import com.programadoresch.perfilusuario.infrastructure.models.EducacionDAO;
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
public class EducacionRepositoryTest {
    @Autowired
    private EducacionCrudRepository repository;
    @Autowired
    private PerfilCrudRepository perfilCrudRepository;
    EducacionDAO educacionDAO = new EducacionDAO();
    List<EducacionDAO> educacionDAOList = new ArrayList<>();
    PerfilDAO perfil = new PerfilDAO();

    @BeforeEach
    void setUp() {
        perfil.setAcercaDe("acercade1");
        perfil.setNombre("nombre1");
        perfil.setApellido("apellido1");
        perfil.setEdad(23);

        perfilCrudRepository.save(perfil);

        educacionDAO.setInstitucion("institucion");
        educacionDAO.setMesInicio(3);
        educacionDAO.setAnnoInicio(2020);
        educacionDAO.setMesFin(4);
        educacionDAO.setAnnoFin(2022);
        educacionDAO.setIdPerfil(1);
        educacionDAO.setPerfil(perfil);

        educacionDAOList.add(educacionDAO);

        repository.save(educacionDAO);
    }

    @AfterEach
    void tearDown() {
        educacionDAO = null;
        repository.deleteAll();
    }

    @Test
    void testFindEducacionDAOByIdEducacion() {
        EducacionDAO educacion = repository.findEducacionDAOByIdEducacion(1);
        assertThat(educacion).isEqualTo(educacionDAO);
    }

    @Test
    void testFindEducacionDAOByIdPerfil() {
        List<EducacionDAO> educacionList = repository.findEducacionDAOByIdPerfil(1);
        assertThat(educacionList).isEqualTo(educacionDAOList);
    }
}
