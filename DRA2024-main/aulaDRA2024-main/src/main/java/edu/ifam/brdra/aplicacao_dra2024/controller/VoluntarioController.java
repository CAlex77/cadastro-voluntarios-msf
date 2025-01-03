package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.dto.VoluntarioDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Voluntario;
import edu.ifam.brdra.aplicacao_dra2024.service.VoluntarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    // Endpoint para cadastrar um novo voluntário
    @PostMapping
    public ResponseEntity<Voluntario> cadastrarVoluntario(@Valid @RequestBody VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = voluntarioService.cadastrarVoluntario(voluntarioDTO);
        return new ResponseEntity<>(voluntario, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os voluntários
    @GetMapping
    public ResponseEntity<List<Voluntario>> listarVoluntarios() {
        List<Voluntario> voluntarios = voluntarioService.listarVoluntarios();
        return new ResponseEntity<>(voluntarios, HttpStatus.OK);
    }

    // Endpoint para excluir um voluntário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVoluntario(@PathVariable Long id) {
        voluntarioService.excluirVoluntario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Retorna status 204 (sem conteúdo)
    }
}
