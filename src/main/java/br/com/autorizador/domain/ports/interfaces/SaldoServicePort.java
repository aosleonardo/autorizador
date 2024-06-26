package br.com.autorizador.domain.ports.interfaces;

import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.infrastructure.entity.SaldoEntity;

import java.math.BigDecimal;
import java.util.Optional;

public interface SaldoServicePort {

    Optional<SaldoEntity> getSaldoCartao(String numeroCartao);
    SaldoDTO getSaldo(String numeroCartao);

    void updateSaldo(Integer idSaldo, BigDecimal total);
}
