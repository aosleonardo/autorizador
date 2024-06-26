package br.com.autorizador.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CartaoDTO(
        @NotBlank(message = "Deve ser informada uma senha valida com 6 digito.")
        @Pattern(regexp = "\\d{6}", message = "Deve ser informada uma senha valida com 6 digito.")
        String senha,
        @NotBlank(message = "Deve ser informado um número válido de cartão com 16 dígitos.")
        @Pattern(regexp = "\\d{16}", message = "Deve ser informado um número válido de cartão com 16 dígitos.")
        String numeroCartao) {

}
