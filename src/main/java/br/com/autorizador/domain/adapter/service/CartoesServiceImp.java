package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.Cartao;
import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.repository.CartaoRepositoryPort;
import br.com.autorizador.domain.ports.repository.ContaRepositoryPort;

public class CartoesServiceImp implements CartoesServicePort {

    private final CartaoRepositoryPort cartaoRepositoryPort;
    private final ContaRepositoryPort contaRepositoryPort;

    public CartoesServiceImp(CartaoRepositoryPort cartaoRepositoryPort, ContaRepositoryPort contaRepositoryPort) {
        this.cartaoRepositoryPort = cartaoRepositoryPort;
        this.contaRepositoryPort = contaRepositoryPort;
    }


    @Override
    public CartaoDTO save(CartaoDTO cartaoDTO) {
        final Cartao cartao = new Cartao(cartaoDTO.senha(), cartaoDTO.numeroCartao());
        return cartaoRepositoryPort.save(cartao);
    }

    @Override
    public SaldoDTO getSaldoCartao(String numeroCartao) {
        return contaRepositoryPort.getSaldoCartao(numeroCartao);
    }
}
