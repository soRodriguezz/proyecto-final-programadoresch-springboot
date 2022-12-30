package com.programadoresch.perfilusuario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.services.experiencia.*;
import com.programadoresch.perfilusuario.infrastructure.adapters.input.ExperienciaController;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestExperienciaDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExperienciaController.class)
public class ExperienciaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SaveExperienciaService save;
    @MockBean
    private GetAllExperienciaService getAll;
    @MockBean
    private GetExperienciaByIdService byId;
    @MockBean
    private UpdateExperienciaService update;
    @MockBean
    private DeleteExperienciaService delete;
    Experiencia experiencia1 = new Experiencia();
    Experiencia experiencia2 = new Experiencia();
    List<Experiencia> experienciaList = new ArrayList<>();
    Perfil perfil = new Perfil();
    RequestExperienciaDTO dto = new RequestExperienciaDTO();

    @BeforeEach
    void setUp() {
        experiencia1 = new Experiencia(
                1,
                "cargo1",
                "nombre1",
                "ubicacion1",
                3,
                2020,
                6,
                2022,
                1,
                perfil);

        experiencia2 = new Experiencia(
                2,
                "cargo2",
                "nombre2",
                "ubicacion2",
                3,
                2020,
                6,
                2022,
                1,
                perfil);

        experienciaList.add(experiencia1);
        experienciaList.add(experiencia2);

        perfil.setIdPerfil(1);
        perfil.setNombre("nombre1");
        perfil.setApellido("apellido1");
        perfil.setAcercaDe("acercade1");
        perfil.setEdad(23);

        dto.setIdExperiencia(1);
        dto.setCargo("cargo1");
        dto.setNombreEmpresa("nombre1");
        dto.setUbicacion("ubicacion1");
        dto.setMesInicio(1);
        dto.setAnnoInicio(2020);
        dto.setMesFin(4);
        dto.setAnnoFin(2022);
        dto.setIdPerfil(1);
        dto.setPerfil(perfil);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveExperiencia() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        when(save.execute(dto)).thenReturn(experiencia1);

        this.mockMvc.perform(post("/experiencia/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void getAllExperiencia() throws Exception {
        when(getAll.execute()).thenReturn(experienciaList);
        this.mockMvc.perform(get("/experiencia/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getByIdExperiencia() throws Exception {
        when(byId.execute(1)).thenReturn(experiencia1);
        this.mockMvc.perform(get("/experiencia/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateExperiencia() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dto);

        when(update.execute(1, dto)).thenReturn(experiencia1);
        this.mockMvc.perform(put("/experiencia/update/" + "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteExperiencia() throws Exception {
        when(delete.execute(1)).thenReturn(true);
        this.mockMvc.perform(delete("/experiencia/delete/" + "1")).andDo(print()).andExpect(status().isOk());
    }

}
