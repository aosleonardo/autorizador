package br.com.autorizador.domain.ports.repository;

import br.com.autorizador.domain.dto.SaldoDTO;

public interface ContaRepositoryPort {

    SaldoDTO getSaldoCartao(String numeroCartao);
}
