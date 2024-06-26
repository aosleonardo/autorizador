package br.com.autorizador.domain.ports.interfaces;

import br.com.autorizador.domain.dto.TransacaoDTO;

public interface TransacaoServicePort{
    public TransacaoDTO transacao(TransacaoDTO transacaoDTO);
}
