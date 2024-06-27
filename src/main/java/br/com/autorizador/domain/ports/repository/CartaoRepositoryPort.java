package br.com.autorizador.domain.ports.repository;

import br.com.autorizador.domain.Cartao;
import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.infrastructure.entity.CartaoEntity;

import java.util.Optional;

public interface CartaoRepositoryPort {

    Optional<CartaoEntity> findByNumeroCartao(String numeroCartao);
    Optional<CartaoEntity> findByNumeroCartaoAndSenha(String numeroCartao, String senha);
    CartaoDTO save(Cartao cartao);

}
