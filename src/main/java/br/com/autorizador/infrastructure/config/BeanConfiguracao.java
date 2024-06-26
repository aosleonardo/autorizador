package br.com.autorizador.infrastructure.config;

import br.com.autorizador.domain.adapter.service.CartoesServiceImp;
import br.com.autorizador.domain.adapter.service.ContaServiceImp;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.interfaces.ContaServicePort;
import br.com.autorizador.domain.ports.repository.CartaoRepositoryPort;
import br.com.autorizador.domain.ports.repository.ContaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    CartoesServicePort cartoesService(CartaoRepositoryPort cartaoRepositoryPort) {
        return new CartoesServiceImp(cartaoRepositoryPort);
    }

    @Bean
    ContaServicePort contaService(ContaRepositoryPort contaRepositoryPort) {
        return new ContaServiceImp(contaRepositoryPort);
    }

}
