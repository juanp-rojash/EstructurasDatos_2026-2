package com.example.DTO;

import com.example.Model.Usuario;

// DTO: representa los datos del cliente que vienen en el JSON.
// El record sirve para almacenar datos de forma sencilla y automática.
public record UsuarioDTO(String nombre, String identificacion ) {

    // Convierte este DTO a un objeto Usuario del modelo de negocio.
    public Usuario DTO_Modelo() { return new Usuario(this.nombre, this.identificacion); }

}
