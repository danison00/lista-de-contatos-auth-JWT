package com.dan.jwt.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoRequestDto {




        private Long id;

        @NotBlank(message = "digite um nome válido")
        private String nome;

        @NotNull(message = "digite um número válido")
        @Size(min = 11, max = 11, message = "o número deve conter 11 dígitos")
        private String numero;

        @NotBlank(message = "digite um email válido")
        private String email;

        private String user;

        public ContatoRequestDto(Long id, String nome, String numero, String email) {
                this.id = id;
                this.nome = nome;
                this.numero = numero;
                this.email = email;
        }

        

}
