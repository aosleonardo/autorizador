package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.adapters.exception.ResourceNotFoundException;
import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.repository.ContaRepositoryPort;
import br.com.autorizador.infrastructure.entity.SaldoEntity;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Component
public class SaldoRepository implements ContaRepositoryPort {
    private final SpringSaldoRepository saldoRepository;
    public SaldoRepository(SpringSaldoRepository contaRepository) {
        this.saldoRepository = contaRepository;
    }
    @Override
    public SaldoDTO getSaldoCartao(String numeroCartao) {
        final Optional<Set<SaldoEntity>> getSaldos = saldoRepository.findByNumeroCartao(numeroCartao);
        final Set<SaldoEntity> saldos = getSaldos.orElseThrow(ResourceNotFoundException::new);
        final SaldoEntity saldo = saldos.stream().max((Comparator.comparing(SaldoEntity::getId))).orElseThrow(ResourceNotFoundException::new);
        return new SaldoDTO(saldo.getSaldo());
    }
}
