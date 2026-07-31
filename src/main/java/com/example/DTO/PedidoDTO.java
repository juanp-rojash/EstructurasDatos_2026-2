package com.example.DTO;

import com.example.Model.Pedido;

// DTO: representa la estructura de los datos que llegan desde el JSON.
// Un record permite definir una clase simple y inmutable para guardar datos.
public record PedidoDTO(UsuarioDTO cliente, float precio ) {

    // Convierte este DTO a un objeto de dominio o modelo de negocio.
    public Pedido DTO_Modelo() { return new Pedido(cliente.DTO_Modelo(), precio); }

}
