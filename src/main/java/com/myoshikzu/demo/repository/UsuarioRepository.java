package com.myoshikzu.demo.repository;

import com.myoshikzu.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT u FROM tb_usuario u WHERE login = :login")
    Usuario findUsuarioByLogin(String login);
}
