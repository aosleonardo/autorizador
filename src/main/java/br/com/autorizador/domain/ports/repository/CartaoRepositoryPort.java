package br.com.autorizador.domain.ports.repository;

import br.com.autorizador.domain.Cartao;
import br.com.autorizador.domain.dto.CartaoDTO;

public interface CartaoRepositoryPort {

    CartaoDTO save(Cartao cartao);

}
