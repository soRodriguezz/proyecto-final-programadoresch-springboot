package com.programadoresch.perfilusuario.application.services.curriculum;

import com.programadoresch.perfilusuario.application.domain.entities.*;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.ports.input.curriculum.CurriculumUseCase;
import com.programadoresch.perfilusuario.application.ports.output.conocimiento.ConocimientoGateway;
import com.programadoresch.perfilusuario.application.ports.output.educacion.EducacionGateway;
import com.programadoresch.perfilusuario.application.ports.output.experiencia.ExperienciaGateway;
import com.programadoresch.perfilusuario.application.ports.output.licenciaCertificacion.LicenciaCertificacionGateway;
import com.programadoresch.perfilusuario.application.ports.output.perfil.PerfilGateway;
import com.programadoresch.perfilusuario.infrastructure.dto.ResponseCurriculumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurriculumService implements CurriculumUseCase {

    @Autowired
    private EducacionGateway educacion;

    @Autowired
    private ConocimientoGateway conocimiento;

    @Autowired
    private ExperienciaGateway experiencia;

    @Autowired
    private LicenciaCertificacionGateway licenciaCertificacion;

    @Autowired
    private PerfilGateway perfil;

    @Override
    public ResponseCurriculumDTO execute(Integer id) throws PerfilNotExistException {

        Perfil perfilModel = perfil.findPerfilByIdPerfil(id);

        if(perfilModel == null) {
            Object[] args = { id };
            throw new PerfilNotExistException("perfil.notexist.message", args);
        }

        ResponseCurriculumDTO cv = new ResponseCurriculumDTO();

        List<Educacion> educacionList = educacion.findEducacionDAOByIdPerfil(id);

        List<Conocimiento> conocimientoList = conocimiento.findConocomientoDAOByIdPerfil(id);

        List<Experiencia> experienciaList = experiencia.findExperienciaDAOByIdPerfil(id);

        List<LicenciaCertificacion> licenciaCertificacionList = licenciaCertificacion.findLicenciaCertificacionDAOByIdPerfil(id);

        cv.setAcercaDe(perfilModel.getAcercaDe());
        cv.setNombre(perfilModel.getNombre());
        cv.setApellido(perfilModel.getApellido());
        cv.setEdad(perfilModel.getEdad());
        cv.setEducacionList(educacionList);
        cv.setConocimientoList(conocimientoList);
        cv.setExperienciaList(experienciaList);
        cv.setLicenciaCertificacionList(licenciaCertificacionList);

        return cv;

    }
}
