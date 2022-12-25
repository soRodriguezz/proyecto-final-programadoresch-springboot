package com.programadoresch.perfilusuario.infrastructure.adapters.input;

import com.programadoresch.perfilusuario.application.domain.entities.Conocimiento;
import com.programadoresch.perfilusuario.application.domain.exception.ConocimientoNotExistException;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.services.conocimiento.*;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestConocimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conocimiento")
public class ConocimientoController {
    @Autowired
    private SaveConocimientoService save;

    @Autowired
    private GetAllConocimientoService getAll;

    @Autowired
    private GetConocimientoByIdService byId;

    @Autowired
    private UpdateConocimientoService update;

    @Autowired
    private DeleteConocimientoService delete;

    @PostMapping("/save")
    public ResponseEntity<Conocimiento> save(@RequestBody RequestConocimientoDTO dto) throws PerfilNotExistException {
        return new ResponseEntity<>(save.execute(dto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Conocimiento>> getAll() {
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conocimiento> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(byId.execute(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Conocimiento> update(@PathVariable int id, @RequestBody RequestConocimientoDTO dto) throws PerfilNotExistException, ConocimientoNotExistException {
        return new ResponseEntity<>(update.execute(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) throws ConocimientoNotExistException {
        return new ResponseEntity<>(delete.execute(id), HttpStatus.OK);
    }

}

