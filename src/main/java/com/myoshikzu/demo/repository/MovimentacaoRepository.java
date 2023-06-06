package com.myoshikzu.demo.repository;

import com.myoshikzu.demo.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MovimentacaoRepository extends JpaRepository<Movimentacao,Long> {

}
