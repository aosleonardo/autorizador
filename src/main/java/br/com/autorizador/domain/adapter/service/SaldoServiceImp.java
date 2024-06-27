package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.adapters.exception.ResourceNotFoundException;
import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;
import br.com.autorizador.domain.ports.repository.SaldoRepositoryPort;
import br.com.autorizador.infrastructure.entity.SaldoEntity;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class SaldoServiceImp implements SaldoServicePort {

    private final SaldoRepositoryPort saldoRepositoryPort;
    public SaldoServiceImp(SaldoRepositoryPort saldoRepositoryPort) {
        this.saldoRepositoryPort = saldoRepositoryPort;
    }

    @Override
    public Optional<SaldoEntity> getSaldoCartao(String numeroCartao) {
        final Set<SaldoEntity> saldoRepository =  saldoRepositoryPort.getSaldoCartao(numeroCartao).orElseThrow(ResourceNotFoundException::new);
        return saldoRepository.stream().max((Comparator.comparing(SaldoEntity::getId)));
    }

    @Override
    public SaldoDTO getSaldo(String numeroCartao) {
        return new SaldoDTO(this.getSaldoCartao(numeroCartao).orElseThrow(ResourceNotFoundException::new).getSaldo());
    }


}
