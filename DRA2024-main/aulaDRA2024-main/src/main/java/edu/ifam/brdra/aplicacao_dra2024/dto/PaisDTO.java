package edu.ifam.brdra.aplicacao_dra2024.dto;

import jakarta.validation.constraints.NotNull;

public class PaisDTO {

    @NotNull
    private String nome;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PaisDTO{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
