package com.example.Model;

import java.util.UUID;

public class Caja  <T> /*< T, K >*/ {

    private UUID id;
    private T contenido;

    public Caja(T contenido) {
        this.id = UUID.randomUUID();
        this.contenido = contenido;
    }

    public UUID getId() {
        return id;
    }

    public T getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "id=" + id +
                ", contenido=" + contenido +
                '}';
    }
}
