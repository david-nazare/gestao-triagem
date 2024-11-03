package com.carrerexpansion.gestao_triagem.infrastructure.repositories;

import com.carrerexpansion.gestao_triagem.core.domain.Triagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TriagemRepository extends JpaRepository<Triagem, UUID> {

}
