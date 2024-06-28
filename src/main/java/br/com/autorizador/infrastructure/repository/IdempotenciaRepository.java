package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.domain.ports.repository.IdempotenciaRepositoryPort;
import br.com.autorizador.infrastructure.entity.IdempotenciaEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class IdempotenciaRepository implements IdempotenciaRepositoryPort {

    private final SpringIdempotenciaRepository springIdempotenciaRepository;

    public IdempotenciaRepository(SpringIdempotenciaRepository springIdempotenciaRepository) {
        this.springIdempotenciaRepository = springIdempotenciaRepository;
    }

    @Override
    public Optional<Idempotencia> findByIdempotenciaStatus(String numeroCartao, BigDecimal valor, LocalDateTime now) {
        return Optional.empty();
    }

    @Override
    public Idempotencia save(IdempotenciaEntity idempotenciaEntity) {
        return new Idempotencia(springIdempotenciaRepository.save(idempotenciaEntity));
    }

    @Override
    public void delete(UUID id) {
        springIdempotenciaRepository.deleteById(id);
    }

    @Override
    public Set<Idempotencia> findByTransacoesIdempotentesAtivas(String numeroCartao, BigDecimal valor) {
        Set<IdempotenciaEntity> idempotenciaEntities = springIdempotenciaRepository.findByTransacoesIdempotentesAtivas(numeroCartao,  valor);

        return idempotenciaEntities.stream().map(a -> new Idempotencia(a.getId(),a.getNumeroCartao(),
                                                        a.getValor(),a.getDtTransacao(),a.getAtivo()))
                                            .collect(Collectors.toSet());
    }
}
