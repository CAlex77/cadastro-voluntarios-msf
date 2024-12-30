package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.brdra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.brdra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.brdra.aplicacao_dra2024.repository.PessoaRepository;
import edu.ifam.brdra.aplicacao_dra2024.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@Tag(name = "Pessoas", description = "APIs para gerenciamento de pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista de pessoas cadastradas.")
    public ResponseEntity<List<PessoaOutputDTO>> list() {
        List<PessoaOutputDTO> pessoasDTO = pessoaService.list();
        if (pessoasDTO.isEmpty()) {
            return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Criar uma nova pessoa",
            description = "Adiciona uma nova pessoa no banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa criada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PessoaOutputDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Erro ao criar pessoa",
                    content = @Content)
    })
    public ResponseEntity<PessoaOutputDTO> Create(@RequestBody PessoaInputDTO pessoaInputDTO) {
        try {
            PessoaOutputDTO pessoaOutputDTO = pessoaService.create(pessoaInputDTO);
            return new ResponseEntity<>(pessoaOutputDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Buscar pessoa por ID",
            description = "Retorna os detalhes de uma pessoa específica."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PessoaOutputDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada",
                    content = @Content)
    })
    public ResponseEntity<PessoaOutputDTO> getById(
            @Parameter(description = "ID da pessoa a ser buscada") @PathVariable Long id) {
        try {
            return new ResponseEntity<>(pessoaService.getById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Deletar pessoa por ID",
            description = "Remove uma pessoa do banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pessoa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada",
                    content = @Content)
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID da pessoa a ser deletada") @PathVariable Long id) {
        try {
            pessoaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Atualizar pessoa por ID",
            description = "Atualiza os detalhes de uma pessoa existente no banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PessoaOutputDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar pessoa",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada",
                    content = @Content)
    })
    public ResponseEntity<PessoaOutputDTO> update(
            @Parameter(description = "Dados atualizados da pessoa") @RequestBody PessoaInputDTO pessoaInputDTO,
            @Parameter(description = "ID da pessoa a ser atualizada") @PathVariable Long id) {
        try {
            PessoaOutputDTO pessoaAtualizada = pessoaService.update(pessoaInputDTO, id);
            return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
