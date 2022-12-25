package com.programadoresch.perfilusuario.application.ports.output.conocimiento;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;

import java.util.List;

public interface ConocimientoGateway {
    List<Conocimiento> getAll();

    Conocimiento getConocimientoById(int idConocimiento);

    List<Conocimiento> findConocomientoDAOByIdPerfil(int idPerfil);

    Conocimiento saveConocimiento(Conocimiento dto);

    Conocimiento updateConocimiento(Conocimiento dto);

    void deleteConocimiento(int idConocimiento);

}
