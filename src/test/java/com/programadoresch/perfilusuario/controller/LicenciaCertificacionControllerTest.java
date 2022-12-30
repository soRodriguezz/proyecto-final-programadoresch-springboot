package com.programadoresch.perfilusuario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.services.licenciaCertificado.*;
import com.programadoresch.perfilusuario.infrastructure.adapters.input.LicenciaCertificadoController;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestLicenciaCertificacionDTO;
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

@WebMvcTest(LicenciaCertificadoController.class)
public class LicenciaCertificacionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaveLicenciaCertificadoService save;
    @MockBean
    private GetAllLicenciaCertificadoService getAll;
    @MockBean
    private GetLicenciaCertificadoByIdService byId;
    @MockBean
    private UpdateLicenciaCertificadoService update;
    @MockBean
    private DeleteLicenciaCertificadoService delete;
    LicenciaCertificacion licencia1 = new LicenciaCertificacion();
    LicenciaCertificacion licencia2 = new LicenciaCertificacion();
    List<LicenciaCertificacion> licenciaList = new ArrayList<>();
    Perfil perfil = new Perfil();
    RequestLicenciaCertificacionDTO dto = new RequestLicenciaCertificacionDTO();

    @BeforeEach
    void setUp() {
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

        licenciaList.add(licencia1);
        licenciaList.add(licencia2);

        dto.setIdLicenciaCertificacion(1);
        dto.setNombreCertificado("nombre1");
        dto.setEmpresaEmisora("empresa1");
        dto.setUrlCertificado("url1");
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
    void saveLicenciaCertificado() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        when(save.execute(dto)).thenReturn(licencia1);

        this.mockMvc.perform(post("/licencia-certificado/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void getAllLicenciaCertificado() throws Exception {
        when(getAll.execute()).thenReturn(licenciaList);
        this.mockMvc.perform(get("/licencia-certificado/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getByIdLicenciaCertificado() throws Exception {
        when(byId.execute(1)).thenReturn(licencia1);
        this.mockMvc.perform(get("/licencia-certificado/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateLicenciaCertificado() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dto);

        when(update.execute(1, dto)).thenReturn(licencia1);
        this.mockMvc.perform(put("/licencia-certificado/update/" + "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteLicenciaCertificado() throws Exception {
        when(delete.execute(1)).thenReturn(true);
        this.mockMvc.perform(delete("/licencia-certificado/delete/" + "1")).andDo(print()).andExpect(status().isOk());
    }
}
