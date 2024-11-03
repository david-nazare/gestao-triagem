package com.carrerexpansion.gestao_triagem.infrastructure.repositories;

import com.carrerexpansion.gestao_triagem.core.domain.CargoHabilidade;
import com.carrerexpansion.gestao_triagem.core.domain.TriagemHabilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CargoHabilidadeRepository extends JpaRepository<CargoHabilidade, Integer> {
    List<CargoHabilidade> findAllByCargoIdIs(Integer id);
}
