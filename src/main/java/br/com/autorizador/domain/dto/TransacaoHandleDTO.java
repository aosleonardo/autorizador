package br.com.autorizador.domain.dto;

import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;

import java.math.BigDecimal;

public class TransacaoHandleDTO {
    private String numeroCartao;
    private String senha;
    private String idIdepotencia;
    private BigDecimal saldo;
    private IdempotenciaServicePort idempotenciaServicePort;
    private SaldoServicePort saldoServicePort;

    public TransacaoHandleDTO() {
    }

    public TransacaoHandleDTO(IdempotenciaServicePort idempotenciaServicePort, SaldoServicePort saldoServicePort) {
        this.idempotenciaServicePort = idempotenciaServicePort;
        this.saldoServicePort = saldoServicePort;
    }

    public TransacaoHandleDTO(String numeroCartao, String senha, String idIdepotencia, BigDecimal saldo,
                              IdempotenciaServicePort idempotenciaServicePort, SaldoServicePort saldoServicePort) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.idIdepotencia = idIdepotencia;
        this.saldo = saldo;
        this.idempotenciaServicePort = idempotenciaServicePort;
        this.saldoServicePort = saldoServicePort;
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

    public String getIdIdepotencia() {
        return idIdepotencia;
    }

    public void setIdIdepotencia(String idIdepotencia) {
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
