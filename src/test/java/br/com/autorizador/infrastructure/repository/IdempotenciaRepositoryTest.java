package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.infrastructure.entity.IdempotenciaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IdempotenciaRepositoryTest {

    @Mock
    private SpringIdempotenciaRepository springIdempotenciaRepository;

    @InjectMocks
    private IdempotenciaRepository idempotenciaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByIdempotenciaStatusReturnsEmpty() {
        assertTrue(idempotenciaRepository.findByIdempotenciaStatus("1234", BigDecimal.TEN, LocalDateTime.now()).isEmpty());
    }

    @Test
    void saveSuccessfully() {
        IdempotenciaEntity entity = new IdempotenciaEntity();
        when(springIdempotenciaRepository.save(any(IdempotenciaEntity.class))).thenReturn(entity);
        assertNotNull(idempotenciaRepository.save(entity));
    }

    @Test
    void deleteSuccessfully() {
        UUID id = UUID.randomUUID();
        doNothing().when(springIdempotenciaRepository).deleteById(id);
        assertDoesNotThrow(() -> idempotenciaRepository.delete(id));
        verify(springIdempotenciaRepository, times(1)).deleteById(id);
    }

    @Test
    void findByTransacoesIdempotentesAtivasSuccessfully() {
        Set<IdempotenciaEntity> entities = Set.of(new IdempotenciaEntity());
        when(springIdempotenciaRepository.findByTransacoesIdempotentesAtivas(anyString(), any(BigDecimal.class))).thenReturn(entities);
        Set<Idempotencia> result = idempotenciaRepository.findByTransacoesIdempotentesAtivas("1234", BigDecimal.TEN);
        assertFalse(result.isEmpty());
    }
}