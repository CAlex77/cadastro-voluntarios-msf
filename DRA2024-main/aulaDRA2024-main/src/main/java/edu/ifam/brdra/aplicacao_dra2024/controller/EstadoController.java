package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.model.Estado;
import edu.ifam.brdra.aplicacao_dra2024.repository.EstadoRepository;
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
@RequestMapping("/api/estado")
@Tag(name = "Estados", description = "APIs para gerenciamento de estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    @Operation(summary = "Listar todos os estados", description = "Retorna uma lista de todos os estados cadastrados.")
    public ResponseEntity<List<Estado>> list() {
        List<Estado> estados = estadoRepository.findAll();

        if (!estados.isEmpty()) {
            return new ResponseEntity<>(estados, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar um novo estado", description = "Cria e salva um novo estado no banco de dados.")
    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
        try {
            Estado estadoSalvoNoBD = estadoRepository.save(estado);

            return new ResponseEntity<>(estadoSalvoNoBD, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar estado por ID", description = "Retorna os detalhes de um estado específico pelo seu ID.")
    public ResponseEntity<Estado> getById(@PathVariable Long id) {
        Optional<Estado> possivelEstado = estadoRepository.findById(id);
        if (possivelEstado.isPresent()) {
            return new ResponseEntity<>(possivelEstado.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar estado por ID", description = "Deleta um estado específico pelo seu ID.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Estado> possivelEstado = estadoRepository.findById(id);

        if (possivelEstado.isPresent()) {
            try {
                estadoRepository.delete(possivelEstado.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar estado por ID", description = "Atualiza os dados de um estado existente pelo seu ID.")
    public ResponseEntity<Estado> update(@RequestBody Estado estado, @PathVariable Long id) {
        Optional<Estado> possivelEstado = estadoRepository.findById(id);

        if (possivelEstado.isPresent()) {
            try {
                Estado estadoAtualizado = possivelEstado.get();
                estadoAtualizado.setNome(estado.getNome());
                estadoAtualizado.setIbge(estado.getIbge());

                Estado estadoSalvoNoBD = estadoRepository.save(estadoAtualizado);

                return new ResponseEntity<>(estadoSalvoNoBD, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
