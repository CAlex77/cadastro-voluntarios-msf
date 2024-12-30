package edu.ifam.brdra.aplicacao_dra2024.model;

import jakarta.persistence.*;

@Entity
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cep;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    private Cidade cidade;

    public Logradouro() {
    }

    public Logradouro(Long id, String cep, String nome, Cidade cidade) {
        this.id = id;
        this.cep = cep;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
