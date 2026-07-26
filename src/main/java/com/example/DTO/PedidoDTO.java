package com.example.DTO;

import com.example.Model.Pedido;

import java.util.UUID;

public record PedidoDTO(UsuarioDTO cliente, float precio) {

    public Pedido DTO_Modelo(){

        return new Pedido(this.cliente.DTO_Modelo(), this.precio);

    }

}
