package br.com.autorizador.infrastructure.config;

import br.com.autorizador.domain.adapter.service.CartoesServiceImp;
import br.com.autorizador.domain.adapter.service.IdempotenciaServiceImp;
import br.com.autorizador.domain.adapter.service.SaldoServiceImp;
import br.com.autorizador.domain.adapter.service.TransacaoServiceImp;
import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.handler.Handler;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;
import br.com.autorizador.domain.ports.interfaces.TransacaoServicePort;
import br.com.autorizador.domain.ports.repository.CartaoRepositoryPort;
import br.com.autorizador.domain.ports.repository.IdempotenciaRepositoryPort;
import br.com.autorizador.domain.ports.repository.SaldoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    CartoesServicePort cartoesService(CartaoRepositoryPort cartaoRepositoryPort) {
        return new CartoesServiceImp(cartaoRepositoryPort);
    }

    @Bean
    SaldoServicePort contaService(SaldoRepositoryPort saldoRepositoryPort) {
        return new SaldoServiceImp(saldoRepositoryPort);
    }
    @Bean
    IdempotenciaServicePort idempotenciaService (IdempotenciaRepositoryPort idempotenciaRepositoryPort) {
        return new IdempotenciaServiceImp(idempotenciaRepositoryPort);
    }
    @Bean
    TransacaoServicePort transacaoService(Handler<TransacaoDTO> handler,
                                          IdempotenciaServicePort idempotenciaServicePort,
                                          SaldoServicePort saldoServicePort) {
        return new TransacaoServiceImp(handler, idempotenciaServicePort, saldoServicePort);
    }
}
