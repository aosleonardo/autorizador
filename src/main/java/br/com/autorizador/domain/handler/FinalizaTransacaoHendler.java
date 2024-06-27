package br.com.autorizador.domain.handler;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;

public class FinalizaTransacaoHendler implements Handler<TransacaoDTO> {

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {
        transacaoHandle.getIdempotenciaServicePort().delete(transacaoHandle.getIdIdepotencia());
    }
}
