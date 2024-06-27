package br.com.autorizador.domain.ports.repository;

import br.com.autorizador.infrastructure.entity.SaldoEntity;

import java.util.Optional;
import java.util.Set;

public interface SaldoRepositoryPort {

    Optional<Set<SaldoEntity>> getSaldoCartao(String numeroCartao);

}
