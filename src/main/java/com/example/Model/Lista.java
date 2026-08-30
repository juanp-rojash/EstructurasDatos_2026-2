package com.example.Model;

public class Lista <T> {

    private Nodo<T> head;
    private int size;

    public Lista () {

        head = null;
        size = 0;

    }

    public void add (T dato) {

        Nodo<T> nodo = new Nodo<>(dato);

        if ( head == null ){

            head = nodo;

        }
        else{

            nodo.setReferencia(head);
            head = nodo;

        }

        size++;

    }

    @Override
    public String toString(){

        String mensaje = "";

        if ( head == null ) mensaje = "Lista Vacia";
        else{

            Nodo<T> aux = head;

            while ( aux != null ){

                mensaje += "[" + aux.getDato() + "] -> ";

                aux = aux.getReferencia();

            }

        }

        return mensaje;

    }

}
