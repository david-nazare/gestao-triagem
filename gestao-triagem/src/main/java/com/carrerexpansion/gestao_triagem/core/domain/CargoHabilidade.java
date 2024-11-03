package com.carrerexpansion.gestao_triagem.core.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="cargo_habilidade")
public class CargoHabilidade {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    Integer cargoId;
    Integer habilidadeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCargoId() {
        return cargoId;
    }

    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getHabilidadeId() {
        return habilidadeId;
    }

    public void setHabilidadeId(Integer habilidadeId) {
        this.habilidadeId = habilidadeId;
    }
}
