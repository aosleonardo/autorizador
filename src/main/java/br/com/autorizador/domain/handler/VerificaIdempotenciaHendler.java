package br.com.autorizador.domain.handler;

import br.com.autorizador.adapters.exception.UnprocessableEntityException;
import br.com.autorizador.domain.Idempotencia;
import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;

import java.time.LocalDateTime;

public class VerificaIdempotenciaHendler implements Handler<TransacaoDTO> {
    private Handler<TransacaoDTO> next;

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
        this.next = next;
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {
        final Boolean idempotenciaStatus = transacaoHandle.getIdempotenciaServicePort().isIdempotenciaAtiva(transacaoHandle.getNumeroCartao(),
                transacaoRequest.valor());

        if (Boolean.FALSE.equals(idempotenciaStatus)) {
            throw new UnprocessableEntityException("TRANSACAO_ATIVA");
        }

        final Idempotencia idempotencia= transacaoHandle.getIdempotenciaServicePort().save(transacaoHandle.getNumeroCartao(),transacaoRequest.valor(), LocalDateTime.now(),Boolean.TRUE);
        transacaoHandle.setIdIdepotencia(idempotencia.getId());
        next.handle(transacaoRequest, transacaoHandle);
    }
}
