package br.com.autorizador.domain.ports.interfaces;

import br.com.autorizador.domain.Idempotencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IdempotenciaServicePort {
    Idempotencia save(String numeroCartao, BigDecimal saldo, LocalDateTime now, Boolean aTrue);

    void delete(UUID id);

    Boolean isIdempotenciaAtiva(String numeroCartao, BigDecimal valor);
}
