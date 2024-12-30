package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.model.Cidade;
import edu.ifam.brdra.aplicacao_dra2024.repository.CidadeRepository;
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
@RequestMapping("/api/cidade")
@Tag(name = "Cidades", description = "APIs para gerenciamento de cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    @Operation(summary = "Listar todas as cidades", description = "Retorna uma lista de todas as cidades cadastradas.")
    public ResponseEntity<List<Cidade>> list() {
        List<Cidade> cidades = cidadeRepository.findAll();

        if (!cidades.isEmpty()) {
            return new ResponseEntity<>(cidades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar uma nova cidade", description = "Cria e salva uma nova cidade no banco de dados.")
    public ResponseEntity<Cidade> create(@RequestBody Cidade cidade) {
        try {
            Cidade cidadeSalvaNoBD = cidadeRepository.save(cidade);
            return new ResponseEntity<>(cidadeSalvaNoBD, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Buscar cidade por ID", description = "Retorna os detalhes de uma cidade específica.")
    public ResponseEntity<Cidade> getById(@PathVariable Long id) {
        Optional<Cidade> possivelCidade = cidadeRepository.findById(id);
        if (possivelCidade.isPresent()) {
            return new ResponseEntity<>(possivelCidade.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar cidade por ID", description = "Deleta uma cidade específica pelo seu ID.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Cidade> possivelCidade = cidadeRepository.findById(id);

        if (possivelCidade.isPresent()) {
            try {
                cidadeRepository.delete(possivelCidade.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar cidade por ID", description = "Atualiza os dados de uma cidade existente pelo seu ID.")
    public ResponseEntity<Cidade> update(@RequestBody Cidade cidade, @PathVariable Long id) {
        Optional<Cidade> possivelCidade = cidadeRepository.findById(id);

        if (possivelCidade.isPresent()) {
            try {
                Cidade cidadeAtualizada = possivelCidade.get();
                cidadeAtualizada.setNome(cidade.getNome());
                cidadeAtualizada.setEstado(cidade.getEstado());

                Cidade cidadeSalvaNoBD = cidadeRepository.save(cidadeAtualizada);
                return new ResponseEntity<>(cidadeSalvaNoBD, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
