package br.com.autorizador.infrastructure.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collation = "idempotencia")
public class IdempotenciaEntity {

    @Id
    private UUID id;
    private String numeroCartao;
    private BigDecimal valor;
    private LocalDateTime dtTransacao;

    private Boolean ativo;

    public IdempotenciaEntity() {
    }

    public IdempotenciaEntity(UUID id, String numeroCartao, BigDecimal valor, LocalDateTime dtTransacao, Boolean ativo) {
        this.id = id;
        this.numeroCartao = numeroCartao;
        this.valor = valor;
        this.dtTransacao = dtTransacao;
        this.ativo = ativo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDtTransacao() {
        return dtTransacao;
    }

    public void setDtTransacao(LocalDateTime dtTransacao) {
        this.dtTransacao = dtTransacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
