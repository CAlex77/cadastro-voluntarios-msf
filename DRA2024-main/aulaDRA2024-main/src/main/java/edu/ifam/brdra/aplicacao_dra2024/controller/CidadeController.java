package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.dto.CidadeDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Cidade;
import edu.ifam.brdra.aplicacao_dra2024.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    // Endpoint para cadastrar uma nova cidade
    @PostMapping
    public ResponseEntity<Cidade> cadastrarCidade(@Valid @RequestBody CidadeDTO cidadeDTO) {
        Cidade cidade = cidadeService.cadastrarCidade(cidadeDTO);
        return new ResponseEntity<>(cidade, HttpStatus.CREATED);
    }

    // Endpoint para listar todas as cidades
    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidades() {
        List<Cidade> cidades = cidadeService.listarCidades();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    // Endpoint para excluir uma cidade
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCidade(@PathVariable Long id) {
        cidadeService.excluirCidade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
