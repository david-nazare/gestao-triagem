package com.carrerexpansion.gestao_triagem.core.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="triagem_habilidades")
public class TriagemHabilidades {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private UUID triagem;
    private Integer habilidade;

    public TriagemHabilidades() {}

    public TriagemHabilidades(UUID triagem, Integer habilidade) {
        this.triagem = triagem;
        this.habilidade = habilidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getTriagem() {
        return triagem;
    }

    public void setTriagem(UUID triagem) {
        this.triagem = triagem;
    }

    public Integer getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Integer habilidade) {
        this.habilidade = habilidade;
    }
}
