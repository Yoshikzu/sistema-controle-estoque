package com.myoshikzu.demo.entity;

import com.myoshikzu.demo.entity.enums.TipoMovimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "codigoBarras")
@Entity(name = "movimentacao")
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "tipo_movimento")
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;

    private int quantidade;
    private LocalDateTime dataMovimentacao;

}
