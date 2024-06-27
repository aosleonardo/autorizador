package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.repository.IdempotenciaRepositoryPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class IdempotenciaServiceImp implements IdempotenciaServicePort {

    private final IdempotenciaRepositoryPort idempotenciaRepositoryPort;

    public IdempotenciaServiceImp(IdempotenciaRepositoryPort idempotenciaRepositoryPort) {
        this.idempotenciaRepositoryPort = idempotenciaRepositoryPort;
    }

    @Override
    public Optional<Idempotencia> findByIdempotenciaStatus(String numeroCartao, BigDecimal valor, LocalDateTime now) {
        return idempotenciaRepositoryPort.findByIdempotenciaStatus(numeroCartao, valor, now);
    }
}
