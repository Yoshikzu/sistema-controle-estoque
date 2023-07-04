package com.myoshikzu.demo.service;

import com.myoshikzu.demo.entity.Movimentacao;
import com.myoshikzu.demo.entity.Produto;
import com.myoshikzu.demo.entity.dto.DadosAtualizacaoMovimentacao;
import com.myoshikzu.demo.entity.dto.DadosAtualizacaoProduto;
import com.myoshikzu.demo.entity.dto.DadosCadastroMovimentacao;
import com.myoshikzu.demo.entity.enums.TipoMovimento;
import com.myoshikzu.demo.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        var produto = produtoService.getProduto(movimentacao.getProduto().getId());
        movimentacao.setProduto(produto);
        return movimentacao;
    }

    public void delete(Long id){
        var movimentacao = this.getMovimentacao(id);
        movimentacaoRepository.delete(movimentacao);
    }

    public Movimentacao update(DadosAtualizacaoMovimentacao dados){
        var movimentacao = this.getMovimentacao(dados.idMovimentacao());

        if(dados.idProduto() != null && dados.idProduto() != movimentacao.getProduto().getId()){
            var produto = produtoService.getProduto(dados.idProduto());
            movimentacao.setProduto(produto);
        }

        if(dados.tipoMovimento() != null && dados.tipoMovimento() != movimentacao.getTipoMovimento()){
            movimentacao.setTipoMovimento(dados.tipoMovimento());
        }

        if(dados.quantidade() != 0 && dados.quantidade() != movimentacao.getQuantidade()){
            movimentacao.setQuantidade(dados.quantidade());
        }

        if(dados.dataMovimentacao() != movimentacao.getDataMovimentacao()){
            movimentacao.setDataMovimentacao(dados.dataMovimentacao());
        }

        movimentacaoRepository.save(movimentacao);
        return movimentacao;
    }
}
