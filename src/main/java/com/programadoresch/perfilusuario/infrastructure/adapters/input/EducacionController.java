package com.programadoresch.perfilusuario.infrastructure.adapters.input;

import com.programadoresch.perfilusuario.application.domain.entities.Educacion;
import com.programadoresch.perfilusuario.application.domain.exception.EducacionNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.services.educacion.*;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestEducacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired
    private SaveEducacionService save;

    @Autowired
    private GetAllEducacionService getAll;

    @Autowired
    private GetEducacionByIdService byId;

    @Autowired
    private UpdateEducacionService update;

    @Autowired
    private DeleteEducacionService delete;

    @PostMapping("/save")
    public ResponseEntity<Educacion> save(@RequestBody RequestEducacionDTO dto) throws PerfilNotExistException {
        return new ResponseEntity<>(save.execute(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> getAll() {
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(byId.execute(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Educacion> update(@PathVariable int id, @RequestBody RequestEducacionDTO dto) throws PerfilNotExistException, EducacionNotExistException {
        return new ResponseEntity<>(update.execute(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) throws EducacionNotExistException {
        return new ResponseEntity<>(delete.execute(id), HttpStatus.OK);
    }
}
