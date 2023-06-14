package com.myoshikzu.demo.controller;

import com.myoshikzu.demo.entity.dto.DadosCadastroMovimentacao;
import com.myoshikzu.demo.entity.dto.DadosCadastroProduto;
import com.myoshikzu.demo.entity.dto.DadosDetalhamentoMovimentacao;
import com.myoshikzu.demo.entity.dto.DadosDetalhamentoProduto;
import com.myoshikzu.demo.service.MovimentacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMovimentacao dados, UriComponentsBuilder uriBuilder){
        var movimentacao = movimentacaoService.insert(dados);
        var uri = uriBuilder.path("/movimentacao/{id}").buildAndExpand(movimentacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMovimentacao(movimentacao));
    }


}

