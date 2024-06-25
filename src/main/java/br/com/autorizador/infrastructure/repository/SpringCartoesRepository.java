package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringCartoesRepository extends JpaRepository<CartaoEntity, Integer> {

}
