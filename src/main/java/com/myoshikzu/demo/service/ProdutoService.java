package com.myoshikzu.demo.service;

import com.myoshikzu.demo.entity.Produto;
import com.myoshikzu.demo.entity.dto.DadosCadastroProduto;
import com.myoshikzu.demo.entity.dto.DadosCadastroUsuario;
import com.myoshikzu.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(DadosCadastroProduto dados){
/*        if (produtoRepository.findProdutoByNome(dados.nome()) != null){
            throw new RuntimeException("Nome do Produto já cadastrado no sistema!");
        }

        if (produtoRepository.findProdutoByCodigoBarras(dados.codigoBarras()) != null){
            throw new RuntimeException("Código de Barras do Produto já cadastrado no sistema!");
        }
*/
        var produto =  new Produto(dados);
        produtoRepository.save(produto);
        return produto;

    }
}
