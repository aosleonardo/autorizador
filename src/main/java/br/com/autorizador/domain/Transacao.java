package br.com.autorizador.domain;

import java.math.BigDecimal;

public class Transacao {
    private String numeroCartao;
    private String senha;
    private BigDecimal valor;

    public Transacao() {
    }

    public Transacao(String numeroCartao, String senha, BigDecimal valor) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.valor = valor;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
