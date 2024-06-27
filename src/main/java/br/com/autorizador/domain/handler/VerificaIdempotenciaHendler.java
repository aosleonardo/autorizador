package br.com.autorizador.domain.handler;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;

public class VerificaIdempotenciaHendler implements Handler<TransacaoDTO> {
    private Handler<TransacaoDTO> next;

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
        this.next = next;
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {
//        final Optional<Idempotencia> idempotencia = idempotenciaServicePort.findByIdempotenciaStatus(transacaoHandle.getNumeroCartao(),
//                transacaoRequest.valor(), LocalDateTime.now());
//        System.out.println("leo");


        next.handle(transacaoRequest, transacaoHandle);
    }
}
