package br.com.autorizador.domain.handler;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;

import java.math.BigDecimal;

public class TransacaoBancariaHendler implements Handler<TransacaoDTO> {
    private Handler<TransacaoDTO> next;

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
        this.next = next;
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {
        final BigDecimal total = transacaoHandle.getSaldo().subtract(transacaoRequest.valor());
        transacaoHandle.getSaldoServicePort().updateSaldo(transacaoHandle.getIdSaldo(), total);


        next.handle(transacaoRequest, transacaoHandle);
    }
}
