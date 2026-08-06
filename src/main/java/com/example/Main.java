package com.example;

import com.example.Model.Caja;

import java.util.*;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class Main {

    public static void main(String[] args) {

        try{

            // Genericos - Parametrizacion
            List<String> estudiantes = new ArrayList<>();

            Caja< Integer > cNumerica1 = new Caja<>(10);
            Caja< String > cString1 = new Caja<>("Contenido Caja");

            // Bag
            Bag<String> mercado = new HashBag<>();

            String dato = "Arroz";

            mercado.add("Aceite");
            mercado.add(dato, 3);
            mercado.add("Muffin");
            mercado.add("Cereal", 5);

            System.out.println("Mercado: " + mercado);

            mercado.remove(dato, 2);

            System.out.println( mercado.uniqueSet() );
            System.out.println("Cantidad de elementos en la bolsa: " + mercado.size());

            // Queue

            Caja<String> c1 = new Caja<>("Santiago");
            Caja<String> c2 = new Caja<>("Juan");
            Caja<String> c3 = new Caja<>("Luis");

            Queue<Caja<String>> fila = new LinkedList<>();

            fila.add(c2);
            fila.add(c1);
            fila.add(c3);

            System.out.println("Primer elemento en salir: " + fila.poll());

            while ( fila.peek() != null ){

                System.out.println("Siguiente elemento de la fila: " + fila.poll());

            }

            // Stack

            Stack<Integer> pila = new Stack<>();

            pila.push(8000);
            pila.push(60);
            pila.push(1);

            while ( !pila.isEmpty() ){

                System.out.println(pila.pop());

            }


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}