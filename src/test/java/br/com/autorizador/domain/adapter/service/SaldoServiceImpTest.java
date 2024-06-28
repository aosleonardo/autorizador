package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.adapters.exception.ResourceNotFoundException;
import br.com.autorizador.domain.ports.repository.SaldoRepositoryPort;
import br.com.autorizador.infrastructure.entity.CartaoEntity;
import br.com.autorizador.infrastructure.entity.SaldoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class SaldoServiceImpTest {

    @Mock
    private SaldoRepositoryPort saldoRepositoryPort;

    @InjectMocks
    private SaldoServiceImp saldoServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSaldoCartaoFound() {
        Set<SaldoEntity> saldos = new HashSet<>();
        saldos.add(new SaldoEntity(new CartaoEntity("1234567890123456", "123"), new BigDecimal("100.00")));
        when(saldoRepositoryPort.getSaldoCartao(anyString())).thenReturn(Optional.of(saldos));

        Optional<SaldoEntity> result = saldoServiceImp.getSaldoCartao("1234567890123456");

        assertTrue(result.isPresent());
        assertEquals(new BigDecimal("100.00"), result.get().getSaldo());
    }

    @Test
    void getSaldoCartaoNotFound() {
        when(saldoRepositoryPort.getSaldoCartao(anyString())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> saldoServiceImp.getSaldoCartao("1234567890123456"));
    }

    @Test
    void updateSaldoSuccess() {
        doNothing().when(saldoRepositoryPort).updateSaldo(anyInt(), any(BigDecimal.class));

        saldoServiceImp.updateSaldo(1, new BigDecimal("150.00"));

        verify(saldoRepositoryPort, times(1)).updateSaldo(1, new BigDecimal("150.00"));
    }
}