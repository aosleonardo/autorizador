package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.IdempotenciaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SpringIdempotenciaRepository extends MongoRepository<IdempotenciaEntity, UUID> {
}
