package com.programadoresch.perfilusuario.infrastructure.adapters.input;

import com.programadoresch.perfilusuario.application.domain.exception.PerfilNotExistException;
import com.programadoresch.perfilusuario.application.services.curriculum.CurriculumService;
import com.programadoresch.perfilusuario.infrastructure.dto.ResponseCurriculumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {
    @Autowired
    private CurriculumService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCurriculumDTO> getById(@PathVariable Integer id) throws PerfilNotExistException {
        return new ResponseEntity<>(service.execute(id), HttpStatus.OK);
    }
}
