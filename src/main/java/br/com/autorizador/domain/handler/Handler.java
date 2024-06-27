package br.com.autorizador.domain.handler;

import br.com.autorizador.domain.dto.TransacaoHandleDTO;

public interface Handler<T> {
    void setNext(Handler<T> next);
    void handle(T transacaoRequest, TransacaoHandleDTO transacaoHandle);
}
