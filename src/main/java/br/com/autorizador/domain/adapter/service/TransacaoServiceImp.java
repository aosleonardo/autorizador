package br.com.autorizador.domain.adapter.service;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.dto.TransacaoHandleDTO;
import br.com.autorizador.domain.handler.Handler;
import br.com.autorizador.domain.ports.interfaces.IdempotenciaServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;
import br.com.autorizador.domain.ports.interfaces.TransacaoServicePort;

public class TransacaoServiceImp implements TransacaoServicePort {
    private final Handler<TransacaoDTO> chain;
    private final IdempotenciaServicePort idempotenciaServicePort;
    private final SaldoServicePort saldoServicePort;
    public TransacaoServiceImp(Handler<TransacaoDTO> chain, IdempotenciaServicePort idempotenciaServicePort, SaldoServicePort saldoServicePort) {
        this.chain = chain;
        this.idempotenciaServicePort = idempotenciaServicePort;
        this.saldoServicePort = saldoServicePort;
    }

    @Override
    public TransacaoDTO transacao(TransacaoDTO transacaoDTO) {
        chain.handle(transacaoDTO, new TransacaoHandleDTO(idempotenciaServicePort, saldoServicePort));
        return transacaoDTO;
    }
}
