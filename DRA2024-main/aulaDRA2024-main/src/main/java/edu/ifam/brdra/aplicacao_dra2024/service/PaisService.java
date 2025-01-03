package edu.ifam.brdra.aplicacao_dra2024.service;

import edu.ifam.brdra.aplicacao_dra2024.dto.PaisDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Pais;
import edu.ifam.brdra.aplicacao_dra2024.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    // Método para cadastrar um novo país
    public Pais cadastrarPais(PaisDTO paisDTO) {
        Pais pais = new Pais();
        pais.setNome(paisDTO.getNome());
        return paisRepository.save(pais);
    }

    // Método para listar todos os países
    public List<Pais> listarPaises() {
        return paisRepository.findAll();
    }

    // Método para excluir um país
    public void excluirPais(Long id) {
        paisRepository.deleteById(id);
    }
}
