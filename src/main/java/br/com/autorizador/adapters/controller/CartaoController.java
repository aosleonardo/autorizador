package br.com.autorizador.adapters.controller;

import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.dto.SaldoDTO;
import br.com.autorizador.domain.ports.interfaces.CartoesServicePort;
import br.com.autorizador.domain.ports.interfaces.ContaServicePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartoesServicePort cartoesPort;

    private final ContaServicePort contaServicePort;

    public CartaoController(CartoesServicePort cartoesPort, ContaServicePort contaServicePort) {
        this.cartoesPort = cartoesPort;
        this.contaServicePort = contaServicePort;
    }

    @PostMapping
    ResponseEntity<CartaoDTO> save(@Valid @RequestBody CartaoDTO cartaoDTO) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(cartoesPort.save(cartaoDTO));
    }

    @GetMapping("/{numeroCartao}")
    ResponseEntity<SaldoDTO> getCartao(@PathVariable(value = "numeroCartao", required = true)
                                        String numeroCartao) {
        return  ResponseEntity.ok(contaServicePort.getSaldoCartao(numeroCartao));
    }
}
