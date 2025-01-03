package edu.ifam.brdra.aplicacao_dra2024.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String passaporte;

    @NotNull
    private String nomeCompleto;

    @NotNull
    private Integer idade;

    @NotNull
    private String telefone;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String tipoSanguineo;

    @ManyToOne
    @NotNull
    private Cidade cidade;

    @ManyToOne
    @NotNull
    private SituacaoSaude situacaoSaude;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public SituacaoSaude getSituacaoSaude() {
        return situacaoSaude;
    }

    public void setSituacaoSaude(SituacaoSaude situacaoSaude) {
        this.situacaoSaude = situacaoSaude;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", passaporte='" + passaporte + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", cidade=" + cidade +
                ", situacaoSaude=" + situacaoSaude +
                '}';
    }
}

