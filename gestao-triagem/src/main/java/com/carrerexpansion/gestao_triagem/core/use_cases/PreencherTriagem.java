package com.carrerexpansion.gestao_triagem.core.use_cases;

import com.carrerexpansion.gestao_triagem.core.domain.TriagemHabilidades;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.TriagemDTO;
import com.carrerexpansion.gestao_triagem.core.use_cases.factories.Factories;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemHabilidadesRepository;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class PreencherTriagem {
    @Autowired
    private TriagemRepository triagemRepository;

    @Autowired
    private TriagemHabilidadesRepository triagemHabilidadesRepository;

    public TriagemDTO preencher(TriagemDTO dto) {
        var triagem = Factories.buildFrom(dto);
        triagem = triagemRepository.save(triagem);

        for (Integer habilidade : dto.habilidades()) {
            var habilidadePrevia = new TriagemHabilidades(triagem.getId(), habilidade);
            triagemHabilidadesRepository.save(habilidadePrevia);
        }

        return Factories.buildFrom(triagem, dto.habilidades());
    }
}
