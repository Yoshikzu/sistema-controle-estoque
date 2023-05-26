package com.myoshikzu.demo.entity;

import com.myoshikzu.demo.entity.enums.NivelUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private NivelUsuario nivelUsuario;
    private String nome;
    private String login;
    private String senha;
}
