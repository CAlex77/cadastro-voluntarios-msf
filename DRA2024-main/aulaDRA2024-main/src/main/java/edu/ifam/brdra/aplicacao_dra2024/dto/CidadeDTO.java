package edu.ifam.brdra.aplicacao_dra2024.dto;

import jakarta.validation.constraints.NotNull;

public class CidadeDTO {

    @NotNull
    private String nome;

    @NotNull
    private Long paisId;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    @Override
    public String toString() {
        return "CidadeDTO{" +
                "nome='" + nome + '\'' +
                ", paisId=" + paisId +
                '}';
    }
}

