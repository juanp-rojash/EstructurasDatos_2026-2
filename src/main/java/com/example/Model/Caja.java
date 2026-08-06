package com.example.Model;

import java.util.Queue;
import java.util.UUID;

public class Caja < T >  /*<T, K>*/ {

    private UUID Id;
    private T Contenido;
    private Queue cola; // Ejemplo

    public Caja ( T contenido ){

        Contenido = contenido;

    }

    public T getContenido(){ return Contenido; }

    @Override
    public String toString() {
        return "Caja{" +
                "Id = " + Id +
                ", Contenido = " + Contenido +
                '}';
    }
}
