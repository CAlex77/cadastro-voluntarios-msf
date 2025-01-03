package edu.ifam.brdra.aplicacao_dra2024.dto;

import jakarta.validation.constraints.NotNull;

public class VoluntarioDTO {

    @NotNull
    private String passaporte;

    @NotNull
    private String nomeCompleto;

    @NotNull
    private Integer idade;

    @NotNull
    private String telefone;

    @NotNull
    private String email;

    @NotNull
    private String tipoSanguineo;

    @NotNull
    private Long cidadeId;

    @NotNull
    private Long situacaoSaudeId;

    // Getters e Setters

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Long getSituacaoSaudeId() {
        return situacaoSaudeId;
    }

    public void setSituacaoSaudeId(Long situacaoSaudeId) {
        this.situacaoSaudeId = situacaoSaudeId;
    }

    @Override
    public String toString() {
        return "VoluntarioDTO{" +
                "passaporte='" + passaporte + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", cidadeId=" + cidadeId +
                ", situacaoSaudeId=" + situacaoSaudeId +
                '}';
    }
}

