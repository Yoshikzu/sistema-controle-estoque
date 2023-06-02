package com.myoshikzu.demo.service;

import com.myoshikzu.demo.entity.Produto;
import com.myoshikzu.demo.entity.Usuario;
import com.myoshikzu.demo.entity.dto.DadosAtualizacaoProduto;
import com.myoshikzu.demo.entity.dto.DadosAtualizacaoUsuario;
import com.myoshikzu.demo.entity.dto.DadosCadastroProduto;
import com.myoshikzu.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(DadosCadastroProduto dados){
        if (produtoRepository.findProdutoByNome(dados.nome()).orElse(null) != null){
            throw new RuntimeException("Nome do Produto já cadastrado no sistema!");
        }

        if (produtoRepository.findProdutoByCodigoBarras(dados.codigoBarras()).orElse(null) != null){
            throw new RuntimeException("Código de Barras do Produto já cadastrado no sistema!");
        }

        if(dados.quantidadeMinima() > dados.saldoInicial()){
            throw new RuntimeException("Quantidade Mínima (" + dados.quantidadeMinima() + " não pode ser menor que o saldo inicial " + dados.saldoInicial());
        }

        var produto =  new Produto(dados);
        produtoRepository.save(produto);
        return produto;
    }

    public Page<Produto> getAll (Pageable paginacao){
        return produtoRepository.findAll(paginacao);
    }

    public Produto getProduto(Long id){
        var produto = produtoRepository.findById(id).orElse(null);
        if(produto == null){
            throw new RuntimeException("Produto (id: " +  id + ") não cadastrado no sistema!");
        }
        return produto;
    }

    public Produto update(DadosAtualizacaoProduto dados){
        var produto = this.getProduto(dados.id());
        if(dados.nome() != null && dados.nome() != produto.getNome()){
            produto.setNome(dados.nome());
        }

        if(dados.codigoBarras() != null && dados.codigoBarras() != produto.getCodigoBarras()){
            produto.setCodigoBarras(dados.codigoBarras());
        }

        if(dados.quantidadeMinima() != 0 && dados.quantidadeMinima() != produto.getQuantidadeMinima()){
            produto.setQuantidadeMinima(dados.quantidadeMinima());
        }

        produtoRepository.save(produto);
        return produto;
    }

    public void delete(Long id){
        var produto = this.getProduto(id);
        produtoRepository.delete(produto);
    }

}
