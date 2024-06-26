package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.infrastructure.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCartoesRepository extends JpaRepository<CartaoEntity, Integer> {

}
