package com.programadoresch.perfilusuario.controller;

import com.programadoresch.perfilusuario.application.domain.entities.*;
import com.programadoresch.perfilusuario.application.services.curriculum.CurriculumService;
import com.programadoresch.perfilusuario.infrastructure.adapters.input.CurriculumController;
import com.programadoresch.perfilusuario.infrastructure.dto.ResponseCurriculumDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurriculumController.class)
public class CurriculumControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CurriculumService service;
    Perfil perfil = new Perfil();
    ResponseCurriculumDTO dto = new ResponseCurriculumDTO();
    List<Conocimiento> conocimientoList = new ArrayList<>();
    List<Educacion> educacionList = new ArrayList<>();
    List<Experiencia> experienciaList = new ArrayList<>();
    List<LicenciaCertificacion> licenciaCertificacionList = new ArrayList<>();

    @BeforeEach
    void setUp() {

        perfil.setIdPerfil(1);
        perfil.setNombre("nombre1");
        perfil.setApellido("apellido1");
        perfil.setAcercaDe("acercade1");
        perfil.setEdad(23);

        Conocimiento conocimiento1 = new Conocimiento();
        conocimiento1.setIdConocimiento(1);
        conocimiento1.setAptitud("aptitud1");
        conocimiento1.setIdPerfil(1);
        conocimiento1.setPerfil(perfil);

        Conocimiento conocimiento2 = new Conocimiento();
        conocimiento2.setIdConocimiento(2);
        conocimiento2.setAptitud("aptitud2");
        conocimiento2.setIdPerfil(1);
        conocimiento2.setPerfil(perfil);

        conocimientoList.add(conocimiento1);
        conocimientoList.add(conocimiento2);

        Educacion educacion1 = new Educacion();
        educacion1.setIdEducacion(1);
        educacion1.setInstitucion("institucion1");
        educacion1.setMesInicio(9);
        educacion1.setAnnoInicio(2020);
        educacion1.setMesFin(4);
        educacion1.setAnnoFin(2022);
        educacion1.setIdPerfil(1);
        educacion1.setPerfil(perfil);

        Educacion educacion2 = new Educacion();
        educacion2.setIdEducacion(2);
        educacion2.setInstitucion("institucion2");
        educacion2.setMesInicio(9);
        educacion2.setAnnoInicio(2020);
        educacion2.setMesFin(4);
        educacion2.setAnnoFin(2022);
        educacion2.setIdPerfil(1);
        educacion2.setPerfil(perfil);

        educacionList.add(educacion2);
        educacionList.add(educacion1);

        Experiencia experiencia1 = new Experiencia();
        experiencia1.setIdExperiencia(1);
        experiencia1.setCargo("cargo1");
        experiencia1.setNombreEmpresa("nombre1");
        experiencia1.setUbicacion("ubicacion1");
        experiencia1.setMesInicio(8);
        experiencia1.setAnnoInicio(2020);
        experiencia1.setMesFin(2);
        experiencia1.setAnnoFin(2022);
        experiencia1.setIdPerfil(1);
        experiencia1.setPerfil(perfil);

        Experiencia experiencia2 = new Experiencia();
        experiencia2.setIdExperiencia(2);
        experiencia2.setCargo("cargo1");
        experiencia2.setNombreEmpresa("nombre1");
        experiencia2.setUbicacion("ubicacion1");
        experiencia2.setMesInicio(8);
        experiencia2.setAnnoInicio(2020);
        experiencia2.setMesFin(2);
        experiencia2.setAnnoFin(2022);
        experiencia2.setIdPerfil(1);
        experiencia2.setPerfil(perfil);

        experienciaList.add(experiencia1);
        experienciaList.add(experiencia2);

        LicenciaCertificacion licencia1 = new LicenciaCertificacion();
        licencia1.setIdLicenciaCertificacion(1);
        licencia1.setNombreCertificado("licencia1");
        licencia1.setEmpresaEmisora("empresa1");
        licencia1.setUrlCertificado("url1");
        licencia1.setMesInicio(4);
        licencia1.setAnnoInicio(2020);
        licencia1.setMesFin(3);
        licencia1.setAnnoFin(2022);
        licencia1.setIdPerfil(1);
        licencia1.setPerfil(perfil);

        LicenciaCertificacion licencia2 = new LicenciaCertificacion();
        licencia2.setIdLicenciaCertificacion(2);
        licencia2.setNombreCertificado("licencia2");
        licencia2.setEmpresaEmisora("empresa1");
        licencia2.setUrlCertificado("url1");
        licencia2.setMesInicio(4);
        licencia2.setAnnoInicio(2020);
        licencia2.setMesFin(3);
        licencia2.setAnnoFin(2022);
        licencia2.setIdPerfil(1);
        licencia2.setPerfil(perfil);

        licenciaCertificacionList.add(licencia1);
        licenciaCertificacionList.add(licencia2);

        dto.setAcercaDe("acercade");
        dto.setNombre("nombre");
        dto.setApellido("apellido");
        dto.setEdad(12);
        dto.setConocimientoList(conocimientoList);
        dto.setEducacionList(educacionList);
        dto.setExperienciaList(experienciaList);
        dto.setLicenciaCertificacionList(licenciaCertificacionList);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCurriculum() throws Exception {
        when(service.execute(1)).thenReturn(dto);
        this.mockMvc.perform(get("/curriculum/" + "1")).andDo(print()).andExpect(status().isOk());
    }
}
