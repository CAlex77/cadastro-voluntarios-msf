package edu.ifam.brdra.aplicacao_dra2024.controller;

import edu.ifam.brdra.aplicacao_dra2024.dto.SituacaoSaudeDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.SituacaoSaude;
import edu.ifam.brdra.aplicacao_dra2024.service.SituacaoSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/situacoes-saude")
public class SituacaoSaudeController {

    @Autowired
    private SituacaoSaudeService situacaoSaudeService;

    // Endpoint para cadastrar uma situação de saúde
    @PostMapping
    public SituacaoSaude cadastrarSituacaoSaude(@RequestBody SituacaoSaudeDTO situacaoSaudeDTO) {
        return situacaoSaudeService.cadastrarSituacaoSaude(situacaoSaudeDTO);
    }

    // Endpoint para listar todas as situações de saúde
    @GetMapping
    public List<SituacaoSaude> listarSituacoesSaude() {
        return situacaoSaudeService.listarSituacoesSaude();
    }

    // Endpoint para excluir uma situação de saúde
    @DeleteMapping("/{id}")
    public void excluirSituacaoSaude(@PathVariable Long id) {
        situacaoSaudeService.excluirSituacaoSaude(id);
    }
}
