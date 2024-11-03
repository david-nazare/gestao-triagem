package com.carrerexpansion.gestao_triagem.core.domain;

import com.carrerexpansion.gestao_triagem.core.domain.exceptions.DomainException;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="triagem")
public class Triagem {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private UUID usuarioId;
    private String profissao;
    private String perfilLinkedin;
    private String areaAtuacao;
    private Integer cargoAtual;
    private String areaDeInteresse;
    private Integer cargoDeInteresse;
    private Integer tempoParaAlcancarObjetivo;

    public Triagem(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getPerfilLinkedin() {
        return perfilLinkedin;
    }

    public void setPerfilLinkedin(String perfilLinkedin) {
        this.perfilLinkedin = perfilLinkedin;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public Integer getCargoAtual() {
        return cargoAtual;
    }

    public void setCargoAtual(Integer cargoAtual) {
        this.cargoAtual = cargoAtual;
    }

    public String getAreaDeInteresse() {
        return areaDeInteresse;
    }

    public void setAreaDeInteresse(String areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }

    public Integer getCargoDeInteresse() {
        return cargoDeInteresse;
    }

    public void setCargoDeInteresse(Integer cargoDeInteresse) {
        this.cargoDeInteresse = cargoDeInteresse;
    }

    public Integer getTempoParaAlcancarObjetivo() {
        return tempoParaAlcancarObjetivo;
    }

    public void setTempoParaAlcancarObjetivo(Integer tempoParaAlcancarObjetivo) {
        this.tempoParaAlcancarObjetivo = tempoParaAlcancarObjetivo;
    }

    public void valida() throws DomainException {
        if (usuarioId == null)
            throw new DomainException("ID do usuário não pode estar vazio");

        if (profissao == null)
            throw new DomainException("Profissão não pode estar vazia");

        if (perfilLinkedin == null)
            throw new DomainException("Perfil do Linkedin não pode estar vazio");

        if (areaAtuacao == null)
            throw new DomainException("Área de atuação não pode estar vazia");

        if (cargoAtual == null)
            throw new DomainException("Cargo atual não pode estar vazio");

        if (areaDeInteresse == null)
            throw new DomainException("Área de interesse não pode estar vazia");

        if (cargoDeInteresse == null)
            throw new DomainException("Cargo de interesse não pode ser vazio");

        if (tempoParaAlcancarObjetivo <= 0)
            throw new DomainException("Tempo para alcançar objetivo deve ser maior que zero");
    }

    @Override
    public String toString() {
        return "Triagem{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", profissao='" + profissao + '\'' +
                ", perfilLinkedin='" + perfilLinkedin + '\'' +
                ", areaAtuacao='" + areaAtuacao + '\'' +
                ", cargoAtual=" + cargoAtual +
                ", areaDeInteresse='" + areaDeInteresse + '\'' +
                ", cargoDeInteresse=" + cargoDeInteresse +
                ", tempoParaAlcancarObjetivo=" + tempoParaAlcancarObjetivo +
                '}';
    }
}
