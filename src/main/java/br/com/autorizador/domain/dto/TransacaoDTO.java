package br.com.autorizador.domain.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record TransacaoDTO(
        @NotBlank(message = "Deve ser informado um número válido de cartão com 16 dígitos.")
        @Pattern(regexp = "\\d{16}", message = "Deve ser informado um número válido de cartão com 16 dígitos.")
        String numeroCartao,
        @NotBlank(message = "Deve ser informada uma senha valida com 6 digito.")
        @Pattern(regexp = "\\d{6}", message = "Deve ser informada uma senha valida com 6 digito.")
        String senha,
        @NotNull(message = "O Valor não pode ser nulo.")
        @DecimalMin(value = "0.00", inclusive = true, message = "O Valor deve ser maior ou igual a zero")
        BigDecimal valor) {
}
