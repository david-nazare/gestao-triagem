package com.carrerexpansion.gestao_triagem.core.use_cases;

import com.carrerexpansion.gestao_triagem.core.domain.TriagemHabilidades;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.TriagemDTO;
import com.carrerexpansion.gestao_triagem.core.use_cases.factories.Factories;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemHabilidadesRepository;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConsultarTriagem {
    @Autowired
    private TriagemRepository triagemRepository;

    @Autowired
    private TriagemHabilidadesRepository triagemHabilidadesRepository;

    public TriagemDTO consultar(UUID id) {
        var triagem = triagemRepository.getReferenceById(id);
        List<TriagemHabilidades> habilidades = triagemHabilidadesRepository.findAllByTriagemIs(id);
        Set<Integer> habilidadesIds = new HashSet<>();

        for (TriagemHabilidades habilidade : habilidades) {
            habilidadesIds.add(habilidade.getHabilidade());
        }

        return Factories.buildFrom(triagem, habilidadesIds);
    }
}
