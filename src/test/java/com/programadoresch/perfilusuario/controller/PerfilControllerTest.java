package com.programadoresch.perfilusuario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.services.perfil.*;
import com.programadoresch.perfilusuario.infrastructure.adapters.input.PerfilController;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;
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

@WebMvcTest(PerfilController.class)
public class PerfilControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SavePerfilService save;
    @MockBean
    private GetAllPerfilService getAll;
    @MockBean
    private GetPerfilByIdService byId;
    @MockBean
    private UpdatePerfilService update;
    @MockBean
    private DeletePerfilService delete;
    Perfil perfil1 = new Perfil();
    Perfil perfil2 = new Perfil();
    List<Perfil> perfilList = new ArrayList<>();
    RequestPerfilDTO dto = new RequestPerfilDTO();

    @BeforeEach
    void setUp() {
        perfil1.setIdPerfil(1);
        perfil1.setAcercaDe("acercade1");
        perfil1.setNombre("nombre1");
        perfil1.setApellido("apellido1");
        perfil1.setEdad(34);

        perfil2.setIdPerfil(2);
        perfil2.setAcercaDe("acercade2");
        perfil2.setNombre("nombre2");
        perfil2.setApellido("apellido2");
        perfil2.setEdad(43);

        perfilList.add(perfil1);
        perfilList.add(perfil2);

        dto.setIdPerfil(1);
        dto.setAcercaDe("acercade");
        dto.setNombre("nombre");
        dto.setApellido("apellido");
        dto.setEdad(25);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void savePerfil() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        when(save.execute(dto)).thenReturn(perfil1);

        this.mockMvc.perform(post("/perfil/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void getAllPerfil() throws Exception {
        when(getAll.execute()).thenReturn(perfilList);
        this.mockMvc.perform(get("/perfil/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getByIdPerfil() throws Exception {
        when(byId.execute(1)).thenReturn(perfil1);
        this.mockMvc.perform(get("/perfil/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updatePerfil() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dto);

        when(update.execute(1, dto)).thenReturn(perfil1);
        this.mockMvc.perform(put("/perfil/update/" + "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deletePerfil() throws Exception {
        when(delete.execute(1)).thenReturn(true);
        this.mockMvc.perform(delete("/perfil/delete/" + "1")).andDo(print()).andExpect(status().isOk());
    }

}
