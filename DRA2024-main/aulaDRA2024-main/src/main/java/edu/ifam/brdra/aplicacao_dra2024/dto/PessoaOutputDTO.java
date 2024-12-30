package edu.ifam.brdra.aplicacao_dra2024.dto;

import edu.ifam.brdra.aplicacao_dra2024.model.Pessoa;

public class PessoaOutputDTO {

    private Long id;
    private String nome;
    private String email;
    private String cidade;

    public PessoaOutputDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.cidade = pessoa.getCidade() != null ? pessoa.getCidade().getNome() : "Sem cidade";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
