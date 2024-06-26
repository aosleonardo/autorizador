package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.interfaces.ContaServicePort;
import br.com.autorizador.domain.ports.repository.ContaRepositoryPort;

public class ContaServiceImp implements ContaServicePort {

    private final ContaRepositoryPort contaRepositoryPort;
    public ContaServiceImp(ContaRepositoryPort contaRepositoryPort) {
        this.contaRepositoryPort = contaRepositoryPort;
    }

    @Override
    public SaldoDTO getSaldoCartao(String numeroCartao) {
        return contaRepositoryPort.getSaldoCartao(numeroCartao);
    }
}
