package com.example.Model;

import org.w3c.dom.Node;

public class LinkedSimpleList <T> {

    private Nodo<T> header;
    private int size;

    public LinkedSimpleList(){

        header = null;
        size = 0;

    }

    public void add(T data){

        Nodo<T> nodo = new Nodo(data);

        if ( header == null ){
            header = nodo;
        }
        else{
            nodo.setNext(header);
            header = nodo;
        }

        size++;

    }

    @Override
    public String toString(){

        String mensaje = "";

        if ( header == null ) { return "Lista vacia"; }

        Nodo<T> referencia = header;

        while ( referencia != null ){

            mensaje += "[" + referencia.getData() + "] -> ";

            referencia = referencia.getNext();

        }

        return mensaje;

    }

}
