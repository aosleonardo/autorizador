package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.repository.IdempotenciaRepositoryPort;
import br.com.autorizador.infrastructure.entity.IdempotenciaEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class IdempotenciaServiceImp implements IdempotenciaServicePort {

    private final IdempotenciaRepositoryPort idempotenciaRepositoryPort;

    public IdempotenciaServiceImp(IdempotenciaRepositoryPort idempotenciaRepositoryPort) {
        this.idempotenciaRepositoryPort = idempotenciaRepositoryPort;
    }

    @Override
    public Idempotencia save(String numeroCartao, BigDecimal saldo, LocalDateTime now, Boolean status) {
        return idempotenciaRepositoryPort.save(IdempotenciaEntity.builder()
                .ativo(status)
                .dtTransacao(now)
                .valor(saldo)
                .numeroCartao(numeroCartao).build());
    }

    @Override
    public void delete(UUID id) {
        idempotenciaRepositoryPort.delete(id);
    }

    @Override
    public Boolean isIdempotenciaAtiva(String numeroCartao, BigDecimal valor) {
        return idempotenciaRepositoryPort.findByTransacoesIdempotentesAtivas(numeroCartao,valor).isEmpty();
    }
}
