package br.com.autorizador.infrastructure.config;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.handler.Handler;
import br.com.autorizador.domain.handler.VerificaCartaoHendler;
import br.com.autorizador.domain.handler.VerificaIdempotenciaHendler;
import br.com.autorizador.domain.handler.VerificaSenhaHendler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainConfig {

    @Bean
    public Handler<TransacaoDTO> chain() {
        Handler<TransacaoDTO> verificaCartao = new VerificaCartaoHendler();
        Handler<TransacaoDTO> verificaSenha = new VerificaSenhaHendler();
        Handler<TransacaoDTO> verificaIdempotencia = new VerificaIdempotenciaHendler();

        verificaCartao.setNext(verificaSenha);
        verificaSenha.setNext(verificaIdempotencia);
        return verificaCartao;

    }

}
