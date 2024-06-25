package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.ContasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface SpringContaRepository extends JpaRepository<ContasEntity, Integer> {
    @Query("FROM contas c WHERE c.cartao.numeroCartao = :numeroCartao ORDER BY c.id DESC")
    Optional<Set<ContasEntity>> findByNumeroCartao(@Param("numeroCartao") String numeroCartao);
}
