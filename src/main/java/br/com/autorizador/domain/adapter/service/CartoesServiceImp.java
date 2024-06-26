package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.Cartao;
import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.repository.CartaoRepositoryPort;

public class CartoesServiceImp implements CartoesServicePort {

    private final CartaoRepositoryPort cartaoRepositoryPort;

    public CartoesServiceImp(CartaoRepositoryPort cartaoRepositoryPort) {
        this.cartaoRepositoryPort = cartaoRepositoryPort;
    }

    @Override
    public CartaoDTO save(CartaoDTO cartaoDTO) {
        final Cartao cartao = new Cartao(cartaoDTO.senha(), cartaoDTO.numeroCartao());
        return cartaoRepositoryPort.save(cartao);
    }
}
