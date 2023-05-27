package com.myoshikzu.demo.entity;

import com.myoshikzu.demo.entity.dto.DadosCadastroUsuario;
import com.myoshikzu.demo.entity.enums.NivelUsuario;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "tb_usuario")
@Entity(name = "tb_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nivelusuario")
    @Enumerated(EnumType.STRING)
    private NivelUsuario nivelUsuario;

    private String nome;
    private String email;
    private String login;
    private String senha;

    public Usuario(DadosCadastroUsuario dados) {
        this.nivelUsuario = dados.nivelUsuario();
        this.nome = dados.nome();
        this.email = dados.email();
        this.login = dados.login();
        this.senha = dados.senha();
    }
}
