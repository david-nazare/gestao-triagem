package com.carrerexpansion.gestao_triagem.core.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="habilidade")
public class Habilidade {
    @Id
    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
