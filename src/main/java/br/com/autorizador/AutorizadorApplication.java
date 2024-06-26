package br.com.autorizador;

import br.com.autorizador.infrastructure.repository.SpringCartoesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {SpringCartoesRepository.class, SpringCartoesRepository.class})
public class AutorizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorizadorApplication.class, args);
	}

}
