package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringCartoesRepository extends JpaRepository<CartaoEntity, Integer> {

    Optional<CartaoEntity> findByNumeroCartao(String numeroCartao);

    Optional<CartaoEntity> findByNumeroCartaoAndSenha(String numeroCartao, String senha);
}
