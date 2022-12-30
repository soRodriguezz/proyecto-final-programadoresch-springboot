package com.programadoresch.perfilusuario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.services.conocimiento.*;
import com.programadoresch.perfilusuario.infrastructure.adapters.input.ConocimientoController;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;
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

@WebMvcTest(ConocimientoController.class)
public class ConocimientoControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SaveConocimientoService save;
    @MockBean
    private GetAllConocimientoService getAll;
    @MockBean
    private GetConocimientoByIdService byId;
    @MockBean
    private UpdateConocimientoService update;
    @MockBean
    private DeleteConocimientoService delete;
    Conocimiento conocimiento1;
    Conocimiento conocimiento2;
    List<Conocimiento> conocimientoList = new ArrayList<>();

    Perfil perfil = new Perfil();

    RequestConocimientoDTO dto = new RequestConocimientoDTO();

    @BeforeEach
    void setUp() {
        conocimiento1 = new Conocimiento(
                1,
                "aptitud1", 1,
                new Perfil(
                    1,
                    "acercade1",
                    "nombre1",
                    "apellido1",
                    26
                ));
        conocimiento2 = new Conocimiento(
                2,
                "aptitud2", 2,
                new Perfil(
                        2,
                        "acercade2",
                        "nombre2",
                        "apellido2",
                        27
                ));

        conocimientoList.add(conocimiento1);
        conocimientoList.add(conocimiento2);

        perfil.setIdPerfil(1);
        perfil.setNombre("nombre1");
        perfil.setApellido("apellido1");
        perfil.setAcercaDe("acercade1");
        perfil.setEdad(23);

        dto.setIdConocimiento(1);
        dto.setAptitud("aptitud1");
        dto.setIdPerfil(1);
        dto.setPerfil(perfil);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveConocimientos() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        when(save.execute(dto)).thenReturn(conocimiento1);

        this.mockMvc.perform(post("/conocimiento/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void getAllConocimientos() throws Exception {
        when(getAll.execute()).thenReturn(conocimientoList);
        this.mockMvc.perform(get("/conocimiento/" + "all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getByIdConocimientos() throws Exception {
        when(byId.execute(1)).thenReturn(conocimiento1);
        this.mockMvc.perform(get("/conocimiento/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateConocimientos() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dto);

        when(update.execute(1, dto)).thenReturn(conocimiento1);
        this.mockMvc.perform(put("/conocimiento/update/" + "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteConocimientos() throws Exception {
        when(delete.execute(1)).thenReturn(true);
        this.mockMvc.perform(delete("/conocimiento/delete/" + "1")).andDo(print()).andExpect(status().isOk());
    }

}
