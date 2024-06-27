package br.com.autorizador.domain.dto;

import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;

import java.math.BigDecimal;
import java.util.UUID;

public class TransacaoHandleDTO {

    private Integer idSaldo;
    private String numeroCartao;
    private String senha;
    private UUID idIdepotencia;
    private BigDecimal saldo;
    private IdempotenciaServicePort idempotenciaServicePort;
    private SaldoServicePort saldoServicePort;

    public TransacaoHandleDTO() {
    }

    public TransacaoHandleDTO(IdempotenciaServicePort idempotenciaServicePort, SaldoServicePort saldoServicePort) {
        this.idempotenciaServicePort = idempotenciaServicePort;
        this.saldoServicePort = saldoServicePort;
    }

    public TransacaoHandleDTO(Integer idSaldo, String numeroCartao, String senha,
                              UUID idIdepotencia, BigDecimal saldo, IdempotenciaServicePort idempotenciaServicePort,
                              SaldoServicePort saldoServicePort) {
        this.idSaldo = idSaldo;
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.idIdepotencia = idIdepotencia;
        this.saldo = saldo;
        this.idempotenciaServicePort = idempotenciaServicePort;
        this.saldoServicePort = saldoServicePort;
    }

    public Integer getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(Integer idSaldo) {
        this.idSaldo = idSaldo;
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

    public UUID getIdIdepotencia() {
        return idIdepotencia;
    }

    public void setIdIdepotencia(UUID idIdepotencia) {
        this.idIdepotencia = idIdepotencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public IdempotenciaServicePort getIdempotenciaServicePort() {
        return idempotenciaServicePort;
    }

    public void setIdempotenciaServicePort(IdempotenciaServicePort idempotenciaServicePort) {
        this.idempotenciaServicePort = idempotenciaServicePort;
    }

    public SaldoServicePort getSaldoServicePort() {
        return saldoServicePort;
    }

    public void setSaldoServicePort(SaldoServicePort saldoServicePort) {
        this.saldoServicePort = saldoServicePort;
    }
}
