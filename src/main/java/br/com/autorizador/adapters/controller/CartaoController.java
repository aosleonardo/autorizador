package br.com.autorizador.adapters.controller;

import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.interfaces.SaldoServicePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartoesServicePort cartoesPort;

    private final SaldoServicePort saldoServicePort;

    public CartaoController(CartoesServicePort cartoesPort, SaldoServicePort saldoServicePort) {
        this.cartoesPort = cartoesPort;
        this.saldoServicePort = saldoServicePort;
    }

    @PostMapping
    ResponseEntity<CartaoDTO> save(@Valid @RequestBody CartaoDTO cartaoDTO) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(cartoesPort.save(cartaoDTO));
    }

    @GetMapping("/{numeroCartao}")
    ResponseEntity<String> getCartao(@PathVariable(value = "numeroCartao", required = true)
                                        String numeroCartao) {
        return  ResponseEntity.ok(saldoServicePort.getSaldo(numeroCartao).saldo().toString());
    }
}
