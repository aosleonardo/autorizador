package br.com.autorizador.domain.ports.interfaces;

import br.com.autorizador.domain.dto.SaldoDTO;

public interface ContaServicePort {

    SaldoDTO getSaldoCartao(String numeroCartao);
}
