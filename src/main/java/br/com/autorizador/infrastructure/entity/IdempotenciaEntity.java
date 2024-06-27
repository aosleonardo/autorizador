package br.com.autorizador.infrastructure.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "idempotencia")
public class IdempotenciaEntity {

    @Id
    private UUID id;
    private String numeroCartao;
    private BigDecimal valor;
    private LocalDateTime dtTransacao;

    private Boolean ativo;

    public IdempotenciaEntity() {
        this.id = UUID.randomUUID();
    }

    public IdempotenciaEntity(UUID id, String numeroCartao, BigDecimal valor, LocalDateTime dtTransacao, Boolean ativo) {
        this.id = UUID.randomUUID();
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private IdempotenciaEntity idempotenciaEntity;

        private Builder() {
            idempotenciaEntity = new IdempotenciaEntity();
        }

        public Builder numeroCartao(String numeroCartao) {
            idempotenciaEntity.setNumeroCartao(numeroCartao);
            return this;
        }

        public Builder valor(BigDecimal valor) {
            idempotenciaEntity.setValor(valor);
            return this;
        }

        public Builder dtTransacao(LocalDateTime dtTransacao) {
            idempotenciaEntity.setDtTransacao(dtTransacao);
            return this;
        }

        public Builder ativo(Boolean ativo) {
            idempotenciaEntity.setAtivo(ativo);
            return this;
        }

        public IdempotenciaEntity build() {
            return idempotenciaEntity;
        }
    }
}
