package com.myoshikzu.demo.controller;

import com.myoshikzu.demo.entity.dto.*;
import com.myoshikzu.demo.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){
        var produto = produtoService.insert(dados);
        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProduto>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        return ResponseEntity.ok(produtoService.getAll(paginacao).map(DadosListagemProduto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharProduto(@PathVariable Long id){
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produtoService.getProduto(id)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados){
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produtoService.update(dados)));
    }

}
