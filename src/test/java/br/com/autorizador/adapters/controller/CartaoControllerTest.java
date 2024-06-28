package br.com.autorizador.adapters.controller;

import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartaoControllerTest {

    @Mock
    private CartoesServicePort cartoesPort;

    @Mock
    private SaldoServicePort saldoServicePort;

    @InjectMocks
    private CartaoController cartaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        CartaoDTO cartaoDTO = new CartaoDTO("123456789", "1234567891234567");
        when(cartoesPort.save(any(CartaoDTO.class))).thenReturn(cartaoDTO);

        ResponseEntity<CartaoDTO> response = cartaoController.save(cartaoDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cartaoDTO, response.getBody());
        verify(cartoesPort, times(1)).save(cartaoDTO);
    }

    @Test
    void testGetCartao() {
        String numeroCartao = "123456789";
        when(saldoServicePort.getSaldo(numeroCartao)).thenReturn(new SaldoDTO(BigDecimal.ZERO));

        ResponseEntity<String> response = cartaoController.getCartao(numeroCartao);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("0", response.getBody());
        verify(saldoServicePort, times(1)).getSaldo(numeroCartao);
    }
}
