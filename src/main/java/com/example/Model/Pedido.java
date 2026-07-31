package com.example.Model;

import java.util.Objects;
import java.util.UUID;

public class Pedido {

    private UUID id;
    private Usuario cliente;
    private float precio;

    public Pedido(Usuario cliente, float precio) {

        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.precio = precio;

    }

    public Usuario getCliente() {
        return cliente;
    }

    public float getPrecio() {
        return precio;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Pedido pedido)) return false;
        return Float.compare(precio, pedido.precio) == 0 && Objects.equals(id, pedido.id) && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, precio);
    }
}
