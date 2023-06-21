package com.myoshikzu.demo.service;

import com.myoshikzu.demo.entity.Movimentacao;
import com.myoshikzu.demo.entity.dto.DadosCadastroMovimentacao;
import com.myoshikzu.demo.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ProdutoService produtoService;

    public Movimentacao insert(DadosCadastroMovimentacao dados){
        if(dados.quantidade() <= 0 ){
            throw new RuntimeException("Quantidade inválida!");
        }

        var produto = produtoService.getProduto(dados.idProduto());

        var movimentacao =  new Movimentacao(produto,dados.quantidade(),dados.tipoMovimento(),dados.dataMovimentacao());
        movimentacaoRepository.save(movimentacao);
        return movimentacao;
    }

    public Page<Movimentacao> getAll (Pageable paginacao){
        return movimentacaoRepository.findAll(paginacao);
    }

    public Movimentacao getMovimentacao(Long id){
        var movimentacao = movimentacaoRepository.findById(id).orElse(null);
        if(movimentacao == null){
            throw new RuntimeException("Movimentação (id: " +  id + ") não cadastrada no sistema!");
        }
        return movimentacao;
    }
}
