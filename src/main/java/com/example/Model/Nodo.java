package com.example.Model;

public class Nodo <T> {

    private T dato;
    private Nodo<T> referencia;

    public Nodo ( T dato ){

        this.dato = dato;
        referencia = null;

    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getReferencia() {
        return referencia;
    }

    public void setReferencia(Nodo<T> referencia) {
        this.referencia = referencia;
    }
}
