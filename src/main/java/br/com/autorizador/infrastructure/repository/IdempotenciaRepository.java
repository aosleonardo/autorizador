package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.domain.ports.repository.IdempotenciaRepositoryPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class IdempotenciaRepository implements IdempotenciaRepositoryPort {

    private final SpringIdempotenciaRepository springIdempotenciaRepository;

    public IdempotenciaRepository(SpringIdempotenciaRepository springIdempotenciaRepository) {
        this.springIdempotenciaRepository = springIdempotenciaRepository;
    }

    @Override
    public Optional<Idempotencia> findByIdempotenciaStatus(String numeroCartao, BigDecimal valor, LocalDateTime now) {
//        Optional<IdempotenciaEntity> a = springIdempotenciaRepository.findByIdempotenciaStatus(numeroCartao,valor, now);
        return Optional.empty();
    }
}
