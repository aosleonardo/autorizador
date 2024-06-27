package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.domain.ports.repository.SaldoRepositoryPort;
import br.com.autorizador.infrastructure.entity.SaldoEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Component
public class SaldoRepository implements SaldoRepositoryPort {
    private final SpringSaldoRepository saldoRepository;
    public SaldoRepository(SpringSaldoRepository contaRepository) {
        this.saldoRepository = contaRepository;
    }
    @Override
    public Optional<Set<SaldoEntity>> getSaldoCartao(String numeroCartao) {
        return saldoRepository.findByNumeroCartao(numeroCartao);

    }

    @Override
    public void updateSaldo(Integer idSaldo, BigDecimal saldo) {
         final Optional<SaldoEntity> saldoEntityOP = saldoRepository.findById(idSaldo);
        SaldoEntity saldoEntity = saldoEntityOP.orElseThrow(RuntimeException::new);

        saldoRepository.save(new SaldoEntity(saldoEntity.getCartao(), saldo));
    }
}
