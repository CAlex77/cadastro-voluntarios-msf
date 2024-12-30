package edu.ifam.brdra.aplicacao_dra2024.service;

import edu.ifam.brdra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.brdra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.brdra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.brdra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.brdra.aplicacao_dra2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;


    public List<PessoaOutputDTO> list() {
        try {
            List<Pessoa> pessoas = pessoaRepository.findAll();
            List<PessoaOutputDTO> pessoaDTOs = new ArrayList<>();

            for (Pessoa pessoa : pessoas) {
                pessoaDTOs.add(new PessoaOutputDTO(pessoa));
            }

            return pessoaDTOs;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public PessoaOutputDTO create ( PessoaInputDTO pessoaInputDTO){

        try {

            Pessoa pessoaSalvaNoBD = pessoaRepository.save(pessoaInputDTO.build(cidadeRepository));

            return new PessoaOutputDTO(pessoaSalvaNoBD);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public PessoaOutputDTO getById (Long id){

        try{
            Optional<Pessoa> possivelPessoa = pessoaRepository.findById(id);

            return new PessoaOutputDTO(possivelPessoa.get());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void delete (Long id){

        try{
            Optional<Pessoa> possivelPessoa = pessoaRepository.findById(id);
            pessoaRepository.delete(possivelPessoa.get());

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public PessoaOutputDTO update (PessoaInputDTO pessoaInputDTO, Long id){
        Pessoa pessoa = pessoaInputDTO.build(cidadeRepository);

        Optional<Pessoa> possivelPessoa = pessoaRepository.findById(id);

        try {
            Pessoa pessoaUpdade = possivelPessoa.get();
            pessoaUpdade.setNome(pessoa.getNome());
            pessoaUpdade.setEmail(pessoa.getEmail());

            Pessoa pessoaSalvaNoBDpessoa = pessoaRepository.save(pessoaUpdade);
            return new PessoaOutputDTO(pessoaSalvaNoBDpessoa);

        }catch (Exception e){
           throw new RuntimeException(e);
        }

    }
}
