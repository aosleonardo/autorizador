package br.com.autorizador.domain.ports.interfaces;

import br.com.autorizador.domain.dto.CartaoDTO;

public interface CartoesServicePort {

    CartaoDTO save(CartaoDTO cartaoDTO);
}
