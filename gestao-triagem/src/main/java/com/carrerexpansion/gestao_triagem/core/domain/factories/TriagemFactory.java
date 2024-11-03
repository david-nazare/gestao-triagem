package com.carrerexpansion.gestao_triagem.core.domain.factories;

import com.carrerexpansion.gestao_triagem.core.domain.Triagem;

import java.util.UUID;

public class TriagemFactory {
    private final Triagem triagem;

    public TriagemFactory() {
        triagem = new Triagem();
    }

    public Triagem build() {
        triagem.valida();
        return triagem;
    }

    public TriagemFactory id(UUID id) {
        triagem.setId(id);
        return this;
    }

    public TriagemFactory usuarioId(UUID usuarioId) {
        triagem.setUsuarioId(usuarioId);
        return this;
    }

    public TriagemFactory profissao(String profissao) {
        triagem.setProfissao(profissao);
        return this;
    }

    public TriagemFactory perfilLinkedin(String perfilLinkedin) {
        triagem.setPerfilLinkedin(perfilLinkedin);
        return this;
    }

    public TriagemFactory areaAtuacao(String areaAtuacao) {
        triagem.setAreaAtuacao(areaAtuacao);
        return this;
    }

    public TriagemFactory cargoAtual(Integer cargoAtual) {
        triagem.setCargoAtual(cargoAtual);
        return this;
    }

    public TriagemFactory areaDeInteresse(String areaDeInteresse) {
        triagem.setAreaDeInteresse(areaDeInteresse);
        return this;
    }

    public TriagemFactory cargoDeInteresse(Integer cargoDeInteresse) {
        triagem.setCargoDeInteresse(cargoDeInteresse);
        return this;
    }

    public TriagemFactory tempoParaAlcancarObjetivo(Integer tempoParaAlcancarObjetivo) {
        triagem.setTempoParaAlcancarObjetivo(tempoParaAlcancarObjetivo);
        return this;
    }
}
