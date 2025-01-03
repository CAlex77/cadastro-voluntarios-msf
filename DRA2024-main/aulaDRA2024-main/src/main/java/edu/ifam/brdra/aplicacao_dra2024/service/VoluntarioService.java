package edu.ifam.brdra.aplicacao_dra2024.service;

import edu.ifam.brdra.aplicacao_dra2024.dto.VoluntarioDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Voluntario;
import edu.ifam.brdra.aplicacao_dra2024.repository.VoluntarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private SituacaoSaudeService situacaoSaudeService;

    @Transactional
    public Voluntario cadastrarVoluntario(VoluntarioDTO voluntarioDTO) {
        Optional<Voluntario> voluntarioExistente = voluntarioRepository.findByPassaporte(voluntarioDTO.getPassaporte());
        if (voluntarioExistente.isPresent()) {
            throw new IllegalArgumentException("Passaporte já cadastrado.");
        }

        Voluntario voluntario = new Voluntario();
        voluntario.setPassaporte(voluntarioDTO.getPassaporte());
        voluntario.setNomeCompleto(voluntarioDTO.getNomeCompleto());
        voluntario.setIdade(voluntarioDTO.getIdade());
        voluntario.setTelefone(voluntarioDTO.getTelefone());
        voluntario.setEmail(voluntarioDTO.getEmail());
        voluntario.setTipoSanguineo(voluntarioDTO.getTipoSanguineo());
        voluntario.setCidade(cidadeService.getCidadeById(voluntarioDTO.getCidadeId()));
        voluntario.setSituacaoSaude(situacaoSaudeService.getSituacaoById(voluntarioDTO.getSituacaoSaudeId()));

        return voluntarioRepository.save(voluntario);
    }
    // Método para listar todos os voluntários
    public List<Voluntario> listarVoluntarios() {
        return voluntarioRepository.findAll();
    }
    // Método para excluir um voluntário pelo ID
    public void excluirVoluntario(Long id) {
        voluntarioRepository.deleteById(id);
    }
}
