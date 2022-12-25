package com.programadoresch.perfilusuario.infrastructure.adapters.input;

import com.programadoresch.perfilusuario.application.domain.entities.Perfil;
import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.services.perfil.*;
import com.programadoresch.perfilusuario.infrastructure.dto.RequestPerfilDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private SavePerfilService save;

    @Autowired
    private GetAllPerfilService getAll;

    @Autowired
    private GetPerfilByIdService getById;

    @Autowired
    private UpdatePerfilService update;

    @Autowired
    private DeletePerfilService delete;

    @PostMapping("/save")
    public ResponseEntity<Perfil> save(@RequestBody RequestPerfilDTO dto) throws Exception {
        return new ResponseEntity<>(save.execute(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(getById.execute(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Perfil>> getAll() {
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Perfil> update(@PathVariable int id, @RequestBody RequestPerfilDTO dto) throws PerfilNotExistException {
        return new ResponseEntity<>(update.execute(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) throws PerfilNotExistException {
        return new ResponseEntity<Boolean>(delete.execute(id), HttpStatus.OK);
    }
}
