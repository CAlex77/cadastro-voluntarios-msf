package edu.ifam.brdra.aplicacao_dra2024.model;

import jakarta.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ibge;

    @Column(nullable = false, unique = true)
    private String nome;

    public Estado() {
    }

    public Estado(Long id, String ibge, String nome) {
        this.id = id;
        this.ibge = ibge;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
