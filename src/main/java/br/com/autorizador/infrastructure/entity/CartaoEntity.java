package br.com.autorizador.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao") // Especifica o nome da coluna da chave estrangeira
    private Integer id;
    @Column(name = "numero_cartao")
    private String numeroCartao;
    @Column(name = "senha")
    private String senha;

    public CartaoEntity() {
    }

    public CartaoEntity(String numeroCartao, String senha) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
