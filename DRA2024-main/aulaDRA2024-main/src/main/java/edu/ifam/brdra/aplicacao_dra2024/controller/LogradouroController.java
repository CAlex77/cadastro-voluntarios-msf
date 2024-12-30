package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.model.Logradouro;
import edu.ifam.brdra.aplicacao_dra2024.repository.LogradouroRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logradouro")
@Tag(name = "Logradouros", description = "APIs para gerenciamento de logradouros")
public class LogradouroController {

    @Autowired
    private LogradouroRepository logradouroRepository;

    @GetMapping
    @Operation(summary = "Listar todos os logradouros", description = "Retorna uma lista de todos os logradouros cadastrados.")
    public ResponseEntity<List<Logradouro>> list() {
        List<Logradouro> logradouros = logradouroRepository.findAll();

        if (!logradouros.isEmpty()) {
            return new ResponseEntity<>(logradouros, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar um novo logradouro", description = "Cria e salva um novo logradouro no banco de dados.")
    public ResponseEntity<Logradouro> create(@RequestBody Logradouro logradouro) {
        try {
            Logradouro logradouroSalvoNoBD = logradouroRepository.save(logradouro);

            return new ResponseEntity<>(logradouroSalvoNoBD, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar logradouro por ID", description = "Retorna os detalhes de um logradouro específico pelo seu ID.")
    public ResponseEntity<Logradouro> getById(@PathVariable Long id) {
        Optional<Logradouro> possivelLogradouro = logradouroRepository.findById(id);
        if (possivelLogradouro.isPresent()) {
            return new ResponseEntity<>(possivelLogradouro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar logradouro por ID", description = "Deleta um logradouro específico pelo seu ID.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Logradouro> possivelLogradouro = logradouroRepository.findById(id);

        if (possivelLogradouro.isPresent()) {
            try {
                logradouroRepository.delete(possivelLogradouro.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar logradouro por ID", description = "Atualiza os dados de um logradouro existente pelo seu ID.")
    public ResponseEntity<Logradouro> update(@RequestBody Logradouro logradouro, @PathVariable Long id) {
        Optional<Logradouro> possivelLogradouro = logradouroRepository.findById(id);

        if (possivelLogradouro.isPresent()) {
            try {
                Logradouro logradouroAtualizado = possivelLogradouro.get();
                logradouroAtualizado.setCep(logradouro.getCep());
                logradouroAtualizado.setNome(logradouro.getNome());
                logradouroAtualizado.setCidade(logradouro.getCidade());

                Logradouro logradouroSalvoNoBD = logradouroRepository.save(logradouroAtualizado);

                return new ResponseEntity<>(logradouroSalvoNoBD, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
