package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.adapters.exception.ResourceNotFoundException;
import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.repository.ContaRepositoryPort;
import br.com.autorizador.infrastructure.entity.ContasEntity;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

@Component
public class ContaRepository implements ContaRepositoryPort {
    private final SpringContaRepository contaRepository;
    public ContaRepository(SpringContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }
    @Override
    public SaldoDTO getSaldoCartao(String numeroCartao) {
        final Optional<Set<ContasEntity>> contas = contaRepository.findByNumeroCartao(numeroCartao);
        final ContasEntity conta = contas.orElseThrow(() -> new ResourceNotFoundException()).
                stream().max(Comparator.comparing(ContasEntity::getId)).get();
        return new SaldoDTO(conta.getSaldo());
    }
}
