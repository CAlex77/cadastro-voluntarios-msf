package edu.ifam.brdra.aplicacao_dra2024.dto;

import edu.ifam.brdra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.brdra.aplicacao_dra2024.repository.CidadeRepository;

public class PessoaInputDTO {

    private String nome;
    private String email;
    private  String cidade;

    public PessoaInputDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa build (CidadeRepository cidadeRepository){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setEmail(this.email);
        pessoa.setCidade(cidadeRepository.findByNome(this.cidade));

        return pessoa;

    }
}
