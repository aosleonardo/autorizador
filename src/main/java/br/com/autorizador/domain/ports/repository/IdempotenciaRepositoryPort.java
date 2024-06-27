package br.com.autorizador.domain.ports.repository;

import br.com.autorizador.domain.Idempotencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public interface IdempotenciaRepositoryPort {
    Optional<Idempotencia> findByIdempotenciaStatus(String numeroCartao, BigDecimal valor, LocalDateTime now);
}