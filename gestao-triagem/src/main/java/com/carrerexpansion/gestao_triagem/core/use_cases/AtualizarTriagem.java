package com.carrerexpansion.gestao_triagem.core.use_cases;

import com.carrerexpansion.gestao_triagem.core.domain.TriagemHabilidades;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.TriagemDTO;
import com.carrerexpansion.gestao_triagem.core.use_cases.factories.Factories;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemHabilidadesRepository;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AtualizarTriagem {
    @Autowired
    private TriagemRepository triagemRepository;

    @Autowired
    private TriagemHabilidadesRepository triagemHabilidadesRepository;

    public TriagemDTO atualizar(UUID id, TriagemDTO dto) {
        var triagem = triagemRepository.getReferenceById(id);
        triagem.setUsuarioId(dto.usuarioId());
        triagem.setProfissao(dto.profissao());
        triagem.setPerfilLinkedin(dto.perfilLinkedin());
        triagem.setAreaAtuacao(dto.areaAtuacao());
        triagem.setCargoAtual(dto.cargoAtual());
        triagem.setAreaDeInteresse(dto.areaDeInteresse());
        triagem.setCargoDeInteresse(dto.cargoDeInteresse());
        triagem.setTempoParaAlcancarObjetivo(dto.tempoParaAlcancarObjetivo());
        triagem = triagemRepository.save(triagem);

        List<TriagemHabilidades> habilidadesAntigas = triagemHabilidadesRepository.findAllByTriagemIs(triagem.getId());
        triagemHabilidadesRepository.deleteAll(habilidadesAntigas);

        for (Integer habilidade : dto.habilidades()) {
            var habilidadePrevia = new TriagemHabilidades(triagem.getId(), habilidade);
            triagemHabilidadesRepository.save(habilidadePrevia);
        }

        return Factories.buildFrom(triagem, dto.habilidades());
    }
}
