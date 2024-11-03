package com.carrerexpansion.gestao_triagem.entrypoints.rest_controllers;

import com.carrerexpansion.gestao_triagem.core.use_cases.AnalisarTriagem;
import com.carrerexpansion.gestao_triagem.core.use_cases.AtualizarTriagem;
import com.carrerexpansion.gestao_triagem.core.use_cases.ConsultarTriagem;
import com.carrerexpansion.gestao_triagem.core.use_cases.PreencherTriagem;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.StatusAnaliseDTO;
import com.carrerexpansion.gestao_triagem.core.use_cases.dtos.TriagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/triagem")
public class TriagemController {
    @Autowired
    private PreencherTriagem preencherTriagem;

    @Autowired
    private AnalisarTriagem analisarTriagem;

    @Autowired
    private AtualizarTriagem atualizarTriagem;

    @Autowired
    private ConsultarTriagem consultarTriagem;

    @PostMapping
    public ResponseEntity<TriagemDTO> preencherTriagem(@RequestBody TriagemDTO triagemDTO) {
        triagemDTO = preencherTriagem.preencher(triagemDTO);
        return new ResponseEntity<>(triagemDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<StatusAnaliseDTO> analisarTriagem(@PathVariable UUID id) {
        var status = analisarTriagem.analisar(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TriagemDTO> atualizarTriagem(@PathVariable UUID id, @RequestBody TriagemDTO triagemDTO) {
        triagemDTO = atualizarTriagem.atualizar(id, triagemDTO);
        return new ResponseEntity<>(triagemDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TriagemDTO> consultarTriagem(@PathVariable UUID id) {
        var triagemDTO = consultarTriagem.consultar(id);
        return new ResponseEntity<>(triagemDTO, HttpStatus.OK);
    }
}
