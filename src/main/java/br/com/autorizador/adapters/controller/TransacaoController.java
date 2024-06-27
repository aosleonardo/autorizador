package br.com.autorizador.adapters.controller;

import br.com.autorizador.domain.dto.TransacaoDTO;
import br.com.autorizador.domain.ports.interfaces.TransacaoServicePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoServicePort transacaoServicePort;

    public TransacaoController(TransacaoServicePort transacaoServicePort) {
        this.transacaoServicePort = transacaoServicePort;
    }

    @PostMapping
    ResponseEntity<String> save(@Valid @RequestBody TransacaoDTO transacaoDTO) {
        transacaoServicePort.transacao(transacaoDTO);
        return  ResponseEntity.ok("OK");
    }
}
