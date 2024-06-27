package br.com.autorizador.domain.handler;

import br.com.autorizador.adapters.exception.UnprocessableEntityException;
import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;
import br.com.autorizador.infrastructure.entity.SaldoEntity;

public class VerificaCartaoHendler implements Handler<TransacaoDTO> {

    private Handler<TransacaoDTO> next;

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
        this.next = next;
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {

        final SaldoEntity saldo = transacaoHandle.getSaldoServicePort().getSaldoCartao(transacaoRequest.numeroCartao())
                .orElseThrow(() -> new UnprocessableEntityException("CARTAO_INEXISTENTE"));

        transacaoHandle.setSaldo(saldo.getSaldo());
        transacaoHandle.setNumeroCartao(saldo.getCartao().getNumeroCartao());
        transacaoHandle.setSenha(saldo.getCartao().getSenha());

        next.handle(transacaoRequest, transacaoHandle);
    }
}
