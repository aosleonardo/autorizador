package br.com.autorizador.infrastructure.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "saldo")
public class SaldoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_saldo")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private CartaoEntity cartao;
    @Column(name = "saldo")
    private BigDecimal saldo;

    public SaldoEntity() {
    }

    public SaldoEntity(CartaoEntity cartao, BigDecimal saldo) {
        this.cartao = cartao;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public CartaoEntity getCartao() {
        return cartao;
    }

    public void setCartao(CartaoEntity cartao) {
        this.cartao = cartao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
