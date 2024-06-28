package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;
import br.com.autorizador.domain.handler.Handler;
import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

class TransacaoServiceImpTest {

    @Mock
    private Handler<TransacaoDTO> chain;

    @Mock
    private IdempotenciaServicePort idempotenciaServicePort;

    @Mock
    private SaldoServicePort saldoServicePort;

    @InjectMocks
    private TransacaoServiceImp transacaoServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransacao() {
        // Given
        TransacaoDTO transacaoDTO = new TransacaoDTO("1231","123123", BigDecimal.ZERO); // Adjust constructor based on actual DTO
        TransacaoHandleDTO transacaoHandleDTO = new TransacaoHandleDTO(idempotenciaServicePort, saldoServicePort);

        // When
        transacaoServiceImp.transacao(transacaoDTO);

        // Then
        verify(chain, times(1)).handle(eq(transacaoDTO), any(TransacaoHandleDTO.class));
    }
}