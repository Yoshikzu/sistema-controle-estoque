package com.myoshikzu.demo.repository;

import com.myoshikzu.demo.entity.Movimentacao;
import com.myoshikzu.demo.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao,Long> {

    @Query("SELECT m FROM movimentacao m")
    Page<Movimentacao> findAll(Pageable paginacao);

    @Query("SELECT m FROM movimentacao m WHERE id = :id")
    Movimentacao getById(Long id);
}
