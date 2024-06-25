package br.com.autorizador.domain.ports.interfaces;

import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.dto.SaldoDTO;

public interface CartoesServicePort {

    CartaoDTO save(CartaoDTO cartaoDTO);
    SaldoDTO getSaldoCartao(String numeroCartao);
}
