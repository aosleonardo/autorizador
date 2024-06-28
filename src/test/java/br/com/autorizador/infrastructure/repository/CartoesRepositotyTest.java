package br.com.autorizador.infrastructure.repository;


import br.com.autorizador.adapters.exception.UnprocessableEntityException;
import br.com.autorizador.domain.Cartao;
import br.com.autorizador.infrastructure.entity.CartaoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CartoesRepositotyTest {

    @Mock
    private SpringCartoesRepository springCartoesRepository;

    @InjectMocks
    private CartoesRepositoty cartoesRepositoty;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByNumeroCartao() {
        when(springCartoesRepository.findByNumeroCartao("1234")).thenReturn(Optional.of(new CartaoEntity()));
        assertDoesNotThrow(() -> cartoesRepositoty.findByNumeroCartao("1234"));
    }

    @Test
    void findByNumeroCartaoAndSenha() {
        when(springCartoesRepository.findByNumeroCartaoAndSenha("1234", "senha")).thenReturn(Optional.of(new CartaoEntity()));
        assertDoesNotThrow(() -> cartoesRepositoty.findByNumeroCartaoAndSenha("1234", "senha"));
    }

    @Test
    void save() {
        Cartao cartao = new Cartao("1234", "senha");
        CartaoEntity cartaoEntity = new CartaoEntity(cartao.getNumeroCartao(), cartao.getSenha());
        when(springCartoesRepository.save(any(CartaoEntity.class))).thenReturn(cartaoEntity);
        assertDoesNotThrow(() -> cartoesRepositoty.save(cartao));
    }

    @Test
    void saveThrowsException() {
        Cartao cartao = new Cartao("1234", "senha");
        when(springCartoesRepository.save(any(CartaoEntity.class))).thenThrow(new RuntimeException());
        assertThrows(UnprocessableEntityException.class, () -> cartoesRepositoty.save(cartao));
    }
}