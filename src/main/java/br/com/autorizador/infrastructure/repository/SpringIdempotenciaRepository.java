package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.IdempotenciaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface SpringIdempotenciaRepository extends MongoRepository<IdempotenciaEntity, UUID> {
    @Query("{ 'ativo': true, 'numeroCartao': ?0, 'valor': ?1 }")
    Set<IdempotenciaEntity> findByTransacoesIdempotentesAtivas(String numeroCartao,BigDecimal valor);
}
