package edu.ifam.brdra.aplicacao_dra2024.service;

import edu.ifam.brdra.aplicacao_dra2024.dto.SituacaoSaudeDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.SituacaoSaude;
import edu.ifam.brdra.aplicacao_dra2024.repository.SituacaoSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoSaudeService {

    @Autowired
    private SituacaoSaudeRepository situacaoSaudeRepository;

    // Método para cadastrar uma nova situação de saúde
    public SituacaoSaude cadastrarSituacaoSaude(SituacaoSaudeDTO situacaoSaudeDTO) {
        SituacaoSaude situacaoSaude = new SituacaoSaude();
        situacaoSaude.setDescricao(situacaoSaudeDTO.getDescricao());
        return situacaoSaudeRepository.save(situacaoSaude);
    }

    // Método para listar todas as situações de saúde
    public List<SituacaoSaude> listarSituacoesSaude() {
        return situacaoSaudeRepository.findAll();
    }

    // Método para excluir uma situação de saúde
    public void excluirSituacaoSaude(Long id) {
        situacaoSaudeRepository.deleteById(id);
    }

    // Método para buscar situação de saúde por ID
    public SituacaoSaude getSituacaoById(Long id) {
        Optional<SituacaoSaude> situacaoSaude = situacaoSaudeRepository.findById(id);
        if (situacaoSaude.isPresent()) {
            return situacaoSaude.get();
        } else {
            throw new RuntimeException("Situação de saúde não encontrada com o ID: " + id);
        }
    }
}

