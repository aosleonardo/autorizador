package br.com.autorizador.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cartoes")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numeroCartao;
    private String senha;

    public CartaoEntity() {
    }
    public CartaoEntity(Integer id, Integer numeroCartao, String senha) {
        this.id = id;
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }

    public CartaoEntity(Integer numeroCartao, String senha) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
