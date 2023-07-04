package com.myoshikzu.demo.controller;

import com.myoshikzu.demo.entity.dto.*;
import com.myoshikzu.demo.service.MovimentacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemMovimentacao>> listar(@PageableDefault(size=10,sort={"dataMovimentacao"}) Pageable paginacao){
        return ResponseEntity.ok(movimentacaoService.getAll(paginacao).map(DadosListagemMovimentacao::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMovimentacao(@PathVariable Long id){
        return ResponseEntity.ok(new DadosDetalhamentoMovimentacao(movimentacaoService.getMovimentacao(id)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        movimentacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMovimentacao dados){
        return ResponseEntity.ok(new DadosDetalhamentoMovimentacao(movimentacaoService.update(dados)));
    }

}

