package com.example.demo.Model.Dto;

import jakarta.validation.constraints.*;

public record UsuarioRequest(

        @NotBlank(message = "Nombre invalido")
        String nombre,

        @NotBlank(message = "Apellido invalido")
        String apellido,

        @Email(message = "Email invalida")
        String email,

        @NotBlank(message = "Password invalido")
        @Size(min = 8)
        String password,

        @Min(value = 18, message = "No se aceptan usuarios menores")
        @Max(value = 120, message = "Edad superior al limite")
        int edad

)
{ }
