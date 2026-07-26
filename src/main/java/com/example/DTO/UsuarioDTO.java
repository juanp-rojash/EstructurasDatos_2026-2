package com.example.DTO;

import com.example.Model.Usuario;

public record UsuarioDTO(String identificacion, String nombre) {

    public Usuario DTO_Modelo(){

        return new Usuario(this.identificacion, this.nombre);

    }

}
