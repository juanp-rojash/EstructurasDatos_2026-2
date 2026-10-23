package com.example.demo.Model.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCredencialesRequest(

        @NotBlank(message = "Email invalido")
        @Email(message = "Email invalido")
        String email,

        @NotBlank(message = "Password invalido")
        String password

) { }