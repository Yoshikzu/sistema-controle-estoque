package com.myoshikzu.demo.repository;

import com.myoshikzu.demo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query("SELECT p FROM produto p WHERE nome ilike :nome")
    Optional<Produto> findProdutoByNome(String nome);

    @Query("SELECT p FROM produto p WHERE codigoBarras ilike :codigoBarras")
    <Optional> Produto findProdutoByCodigoBarras(String codigoBarras);
}


