package br.com.autorizador.domain.handler;

import br.com.autorizador.adapters.exception.UnprocessableEntityException;
import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;

import java.util.Optional;

public class VerificaSenhaHendler implements Handler<TransacaoDTO> {
    private Handler<TransacaoDTO> next;

    @Override
    public void setNext(Handler<TransacaoDTO> next) {
        this.next = next;
    }

    @Override
    public void handle(TransacaoDTO transacaoRequest, TransacaoHandleDTO transacaoHandle) {

        Optional.of(transacaoRequest.senha().equals(transacaoHandle.getSenha()))
                .filter(isEqual -> isEqual)
                .orElseThrow(() -> new UnprocessableEntityException("SENHA_INVALIDA"));

        next.handle(transacaoRequest, transacaoHandle);
    }
}
