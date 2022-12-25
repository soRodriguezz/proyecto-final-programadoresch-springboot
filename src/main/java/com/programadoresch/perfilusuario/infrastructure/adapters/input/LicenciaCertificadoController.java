package com.programadoresch.perfilusuario.infrastructure.adapters.input;

import com.programadoresch.perfilusuario.application.domain.entities.LicenciaCertificacion;
import com.programadoresch.perfilusuario.application.domain.exception.LicenciaCertificadoNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.services.licenciaCertificado.*;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestLicenciaCertificacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licencia-certificado")
public class LicenciaCertificadoController {

    @Autowired
    private SaveLicenciaCertificadoService save;

    @Autowired
    private GetAllLicenciaCertificadoService getAll;

    @Autowired
    private GetLicenciaCertificadoByIdService byId;

    @Autowired
    private UpdateLicenciaCertificadoService update;

    @Autowired
    private DeleteLicenciaCertificadoService delete;

    @PostMapping("/save")
    public ResponseEntity<LicenciaCertificacion> save(@RequestBody RequestLicenciaCertificacionDTO dto) throws PerfilNotExistException {
        return new ResponseEntity<>(save.execute(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LicenciaCertificacion>> getAll() {
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicenciaCertificacion> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(byId.execute(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LicenciaCertificacion> update(@PathVariable int id, @RequestBody RequestLicenciaCertificacionDTO dto) throws PerfilNotExistException, LicenciaCertificadoNotExistException {
        return new ResponseEntity<>(update.execute(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) throws LicenciaCertificadoNotExistException {
        return new ResponseEntity<>(delete.execute(id), HttpStatus.OK);
    }

}
