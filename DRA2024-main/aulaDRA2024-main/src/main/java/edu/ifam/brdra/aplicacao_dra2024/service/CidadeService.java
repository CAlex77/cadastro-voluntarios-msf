package edu.ifam.brdra.aplicacao_dra2024.service;

import edu.ifam.brdra.aplicacao_dra2024.dto.CidadeDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Cidade;
import edu.ifam.brdra.aplicacao_dra2024.model.Pais;
import edu.ifam.brdra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.brdra.aplicacao_dra2024.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PaisRepository paisRepository;

    // Método para cadastrar uma nova cidade
    public Cidade cadastrarCidade(CidadeDTO cidadeDTO) {
        Pais pais = paisRepository.findById(cidadeDTO.getPaisId())
                .orElseThrow(() -> new RuntimeException("Pais não encontrado"));

        Cidade cidade = new Cidade();
        cidade.setNome(cidadeDTO.getNome());
        cidade.setPais(pais);

        return cidadeRepository.save(cidade);
    }

    // Método para listar todas as cidades
    public List<Cidade> listarCidades() {
        return cidadeRepository.findAll();
    }

    // Método para excluir uma cidade
    public void excluirCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    // Método para buscar cidade por ID (adicionado)
    public Cidade getCidadeById(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        if (cidade.isPresent()) {
            return cidade.get();
        } else {
            throw new RuntimeException("Cidade não encontrada com o ID: " + id);
        }
    }
}
