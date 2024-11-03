package com.carrerexpansion.gestao_triagem.core.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="cargo")
public class Cargo {
    @Id
    private int id;
    private String descricao;
    private int tempoMinimo;

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

    public int getTempoMinimo() {
        return tempoMinimo;
    }

    public void setTempoMinimo(int tempoMinimo) {
        this.tempoMinimo = tempoMinimo;
    }
}
