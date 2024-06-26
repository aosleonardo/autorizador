package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.SaldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SpringSaldoRepository extends JpaRepository<SaldoEntity, Integer> {
   @Query("SELECT c FROM SaldoEntity c WHERE c.cartao.numeroCartao = :numeroCartao ORDER BY c.id DESC")
   Optional<Set<SaldoEntity>> findByNumeroCartao(@Param("numeroCartao") String numeroCartao);
}
