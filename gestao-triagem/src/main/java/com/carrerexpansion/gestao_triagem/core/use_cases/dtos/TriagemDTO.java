package com.carrerexpansion.gestao_triagem.core.use_cases.dtos;

import java.util.Set;
import java.util.UUID;

public record TriagemDTO(
        UUID id,
        UUID usuarioId,
        String profissao,
        String perfilLinkedin,
        String areaAtuacao,
        Integer cargoAtual,
        String areaDeInteresse,
        Integer cargoDeInteresse,
        Integer tempoParaAlcancarObjetivo,
        Set<Integer> habilidades
) {}
