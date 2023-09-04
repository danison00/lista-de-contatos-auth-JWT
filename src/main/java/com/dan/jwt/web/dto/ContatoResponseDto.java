package com.dan.jwt.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoResponseDto(
        @NotNull Long id,

        @NotBlank(message = "Adicione um nome válido") String nome,

        @NotBlank(message = "Adicione um número válido") String numero,

        @NotBlank(message = "Adicione um email válido") String email) {

}
