package br.com.autorizador.domain;

public class Cartao {
    private String senha;
    private String numeroCartao;

    public Cartao() {}

    public Cartao(String senha, String numeroCartao) {
        this.senha = senha;
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}


