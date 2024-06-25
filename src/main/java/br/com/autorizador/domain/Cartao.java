package br.com.autorizador.domain;

public class Cartao {
    private String senha;
    private Integer numeroCartao;

    public Cartao() {
    }

    public Cartao(String senha, Integer numeroCartao) {
        this.senha = senha;
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
