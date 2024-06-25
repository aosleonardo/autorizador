package br.com.autorizador.infrastructure.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "contas")
public class ContasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private List<CartaoEntity> cartao;
    private BigDecimal saldo;

    public ContasEntity() {
    }

    public ContasEntity(List<CartaoEntity> cartao, BigDecimal saldo) {
        this.cartao = cartao;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public List<CartaoEntity> getCartao() {
        return cartao;
    }

    public void setCartao(List<CartaoEntity> cartao) {
        this.cartao = cartao;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
