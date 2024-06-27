package br.com.autorizador.infrastructure.config;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainConfig {

    @Bean
    public Handler<TransacaoDTO> chain() {
        Handler<TransacaoDTO> verificaCartao = new VerificaCartaoHendler();
        Handler<TransacaoDTO> verificaSenha = new VerificaSenhaHendler();
        Handler<TransacaoDTO> verificaIdempotencia = new VerificaIdempotenciaHendler();
        Handler<TransacaoDTO> verificaSaldoHendler = new VerificaSaldoHendler();
        Handler<TransacaoDTO> transacaoBancariaHendler = new TransacaoBancariaHendler();
        Handler<TransacaoDTO> finalizaTransacaoHendler = new FinalizaTransacaoHendler();

        verificaCartao.setNext(verificaSenha);
        verificaSenha.setNext(verificaIdempotencia);
        verificaIdempotencia.setNext(verificaSaldoHendler);
        verificaSaldoHendler.setNext(transacaoBancariaHendler);
        transacaoBancariaHendler.setNext(finalizaTransacaoHendler);
        return verificaCartao;

    }

}
