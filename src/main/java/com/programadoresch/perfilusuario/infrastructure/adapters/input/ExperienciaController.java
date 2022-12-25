package com.programadoresch.perfilusuario.infrastructure.adapters.input;

import com.programadoresch.perfilusuario.application.domain.entities.Experiencia;
import com.programadoresch.perfilusuario.application.domain.exception.ExperienciaNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.services.experiencia.*;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestExperienciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    private SaveExperienciaService save;

    @Autowired
    private GetAllExperienciaService getAll;

    @Autowired
    private GetExperienciaByIdService byId;

    @Autowired
    private UpdateExperienciaService update;

    @Autowired
    private DeleteExperienciaService delete;

    @PostMapping("/save")
    public ResponseEntity<Experiencia> save(@RequestBody RequestExperienciaDTO dto) throws PerfilNotExistException {
        return new ResponseEntity<>(save.execute(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> getAll() {
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(byId.execute(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Experiencia> update(@PathVariable int id, @RequestBody RequestExperienciaDTO dto) throws PerfilNotExistException, ExperienciaNotExistException {
        return new ResponseEntity<>(update.execute(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) throws ExperienciaNotExistException {
        return new ResponseEntity<>(delete.execute(id), HttpStatus.OK);
    }

}
