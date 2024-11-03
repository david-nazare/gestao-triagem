package com.carrerexpansion.gestao_triagem.core.use_cases.factories;

import com.carrerexpansion.gestao_triagem.core.domain.Triagem;
import com.carrerexpansion.gestao_triagem.core.domain.factories.TriagemFactory;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.TriagemDTO;

import java.util.Set;

public class Factories {

    public static TriagemDTO buildFrom(Triagem triagem, Set<Integer> habilidades) {

        return new TriagemDTO(
                triagem.getId(),
                triagem.getUsuarioId(),
                triagem.getProfissao(),
                triagem.getPerfilLinkedin(),
                triagem.getAreaAtuacao(),
                triagem.getCargoAtual(),
                triagem.getAreaDeInteresse(),
                triagem.getCargoDeInteresse(),
                triagem.getTempoParaAlcancarObjetivo(),
                habilidades
        );
    }

    public static Triagem buildFrom(TriagemDTO triagemDTO) {
        return new TriagemFactory()
                .id(triagemDTO.id())
                .usuarioId(triagemDTO.usuarioId())
                .profissao(triagemDTO.profissao())
                .perfilLinkedin(triagemDTO.perfilLinkedin())
                .areaAtuacao(triagemDTO.areaAtuacao())
                .cargoAtual(triagemDTO.cargoAtual())
                .areaDeInteresse(triagemDTO.areaDeInteresse())
                .cargoDeInteresse(triagemDTO.cargoDeInteresse())
                .tempoParaAlcancarObjetivo(triagemDTO.tempoParaAlcancarObjetivo())
                .build();
    }
}
