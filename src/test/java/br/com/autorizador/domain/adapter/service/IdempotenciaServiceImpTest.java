package br.com.autorizador.domain.adapter.service;


import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.domain.ports.repository.IdempotenciaRepositoryPort;
import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class IdempotenciaServiceImpTest {

    @Mock
    private IdempotenciaRepositoryPort idempotenciaRepositoryPort;

    @InjectMocks
    private IdempotenciaServiceImp idempotenciaServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveSuccess() {
        // Given
        String numeroCartao = "1234567890123456";
        BigDecimal saldo = new BigDecimal("100.00");
        LocalDateTime now = LocalDateTime.now();
        Boolean status = true;
        Idempotencia expectedIdempotencia = new Idempotencia(); // Assuming Idempotencia has a no-arg constructor and setters
        when(idempotenciaRepositoryPort.save(any())).thenReturn(expectedIdempotencia);

        // When
        Idempotencia result = idempotenciaServiceImp.save(numeroCartao, saldo, now, status);

        // Then
        assertNotNull(result);
        verify(idempotenciaRepositoryPort, times(1)).save(any());
    }

    @Test
    void testDeleteSuccess() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        idempotenciaServiceImp.delete(id);

        // Then
        verify(idempotenciaRepositoryPort, times(1)).delete(id);
    }

    @Test
    void testIsIdempotenciaAtiva() {
        // Given
        String numeroCartao = "1234567890123456";
        BigDecimal valor = new BigDecimal("100.00");
        when(idempotenciaRepositoryPort.findByTransacoesIdempotentesAtivas(numeroCartao, valor)).thenReturn(new Array2DHashSet<>());

        // When
        Boolean result = idempotenciaServiceImp.isIdempotenciaAtiva(numeroCartao, valor);

        // Then
        assertTrue(result);
    }
}