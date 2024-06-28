package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.Cartao;
import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.ports.repository.CartaoRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartoesServiceImpTest {

    @Mock
    private CartaoRepositoryPort cartaoRepositoryPort;

    @InjectMocks
    private CartoesServiceImp cartoesServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSaveSuccess() {
        // Given
        CartaoDTO cartaoDTO = new CartaoDTO("1234567890123456", "1234");
        Cartao cartao = new Cartao("1234", "1234567890123456");
        when(cartaoRepositoryPort.save(any(Cartao.class))).thenReturn(cartaoDTO);

        // When
        CartaoDTO result = cartoesServiceImp.save(cartaoDTO);

        // Then
        assertNotNull(result);
        assertEquals(cartaoDTO.numeroCartao(), result.numeroCartao());
        assertEquals(cartaoDTO.senha(), result.senha());
        verify(cartaoRepositoryPort, times(1)).save(any(Cartao.class));
    }
}