package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.dto.PaisDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Pais;
import edu.ifam.brdra.aplicacao_dra2024.service.PaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    // Endpoint para cadastrar um novo país
    @PostMapping
    public ResponseEntity<Pais> cadastrarPais(@Valid @RequestBody PaisDTO paisDTO) {
        Pais pais = paisService.cadastrarPais(paisDTO);
        return new ResponseEntity<>(pais, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os países
    @GetMapping
    public ResponseEntity<List<Pais>> listarPaises() {
        List<Pais> paises = paisService.listarPaises();
        return new ResponseEntity<>(paises, HttpStatus.OK);
    }

    // Endpoint para excluir um país
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPais(@PathVariable Long id) {
        paisService.excluirPais(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

