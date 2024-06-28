package br.com.autorizador.infrastructure.repository;


import br.com.autorizador.infrastructure.entity.SaldoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SpringSaldoRepositoryTest {

    @Mock
    private SpringSaldoRepository springSaldoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByNumeroCartaoReturnsData() {
        Set<SaldoEntity> expectedSaldoSet = new HashSet<>();
        expectedSaldoSet.add(new SaldoEntity()); // Populate with expected data

        when(springSaldoRepository.findByNumeroCartao("1234")).thenReturn(Optional.of(expectedSaldoSet));

        Optional<Set<SaldoEntity>> result = springSaldoRepository.findByNumeroCartao("1234");

        assertEquals(expectedSaldoSet, result.get(), "The returned data should match the expected saldo entities");
    }
}
