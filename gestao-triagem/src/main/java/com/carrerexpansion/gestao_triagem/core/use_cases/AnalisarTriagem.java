package com.carrerexpansion.gestao_triagem.core.use_cases;

import com.carrerexpansion.gestao_triagem.core.domain.Cargo;
import com.carrerexpansion.gestao_triagem.core.domain.CargoHabilidade;
import com.carrerexpansion.gestao_triagem.core.domain.Triagem;
import com.carrerexpansion.gestao_triagem.core.domain.TriagemHabilidades;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.StatusAnaliseDTO;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.TriagemDTO;
import com.carrerexpansion.gestao_triagem.core.use_cases.exceptions.AnaliseTriagemException;
import com.carrerexpansion.gestao_triagem.core.use_cases.factories.Factories;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.CargoHabilidadeRepository;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.CargoRepository;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemHabilidadesRepository;
import com.carrerexpansion.gestao_triagem.infrastructure.repositories.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnalisarTriagem {
    @Autowired
    private TriagemRepository triagemRepository;

    @Autowired
    private TriagemHabilidadesRepository triagemHabilidadesRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CargoHabilidadeRepository cargoHabilidadeRepository;

    public StatusAnaliseDTO analisar(UUID triagemId) {
        Triagem triagem = triagemRepository.findById(triagemId).orElseThrow(() -> new AnaliseTriagemException("ID da triagem não existe"));
        List<TriagemHabilidades> habilidadesTriagem = triagemHabilidadesRepository.findAllByTriagemIs(triagemId);
        List<CargoHabilidade> habilidadesCargo = cargoHabilidadeRepository.findAllByCargoIdIs(triagem.getCargoDeInteresse());
        Cargo cargo = cargoRepository.findById(triagem.getCargoDeInteresse()).orElseThrow(() -> new AnaliseTriagemException("Cargo de interesse não existe"));

        if (triagem.getAreaAtuacao() == triagem.getAreaDeInteresse() &&
                triagem.getCargoAtual() == triagem.getCargoDeInteresse()) {
            throw new AnaliseTriagemException("O cargo/área de interesse deve ser diferente do cargo/área atual");
        }

        if (triagem.getTempoParaAlcancarObjetivo() > cargo.getTempoMinimo()) {
            throw new AnaliseTriagemException(
                    "O cargo " + cargo.getDescricao() +
                            " não pode ser atingido num prazo inferior a " +
                            cargo.getTempoMinimo()
            );
        }

        boolean encontrou;

        for (CargoHabilidade habilidadeCargo : habilidadesCargo) {
            encontrou = false;

            for (TriagemHabilidades habilidadeTriagem : habilidadesTriagem) {
                if (habilidadeTriagem.getHabilidade().equals(habilidadeCargo.getHabilidadeId())) {
                    encontrou = true;
                    break;
                }
            }

            if (!encontrou) {
                throw new AnaliseTriagemException("O cliente não possui todas as habilidades para o cargo almejado");
            }
        }

        return new StatusAnaliseDTO(
                "Análise realizada com sucesso. Nenhuma inconsistência encontrada"
        );
    }
}
