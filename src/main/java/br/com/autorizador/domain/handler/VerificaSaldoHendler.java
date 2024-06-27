package br.com.autorizador.domain.handler;

import br.com.autorizador.adapters.exception.UnprocessableEntityException;
import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;

import java.math.BigDecimal;

public class VerificaSaldoHendler implements Handler<TransacaoDTO> {
    private Handler<TransacaoDTO> next;

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
        this.next = next;
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {
        final BigDecimal total = transacaoHandle.getSaldo().subtract(transacaoRequest.valor());

        if (total.compareTo(BigDecimal.ZERO) < 0) {
            transacaoHandle.getIdempotenciaServicePort().delete(transacaoHandle.getIdIdepotencia());
            throw new UnprocessableEntityException("SALDO_INSUFICIENTE");
        }
        next.handle(transacaoRequest, transacaoHandle);
    }
}
