package br.com.autorizador.domain.ports.repository;

import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.infrastructure.entity.IdempotenciaEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface IdempotenciaRepositoryPort {
    Optional<Idempotencia> findByIdempotenciaStatus(String numeroCartao, BigDecimal valor, LocalDateTime now);
    Idempotencia save(IdempotenciaEntity build);

    void delete(UUID id);

    Set<Idempotencia> findByTransacoesIdempotentesAtivas(String numeroCartao, BigDecimal valor);
}
