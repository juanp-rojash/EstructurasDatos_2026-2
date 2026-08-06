package com.example;

import com.example.Model.Caja;

import java.util.*;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class Main {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();

        Caja<String> nombre = new Caja<>("Contenido");
        Caja<Float> temp = new Caja<>(0.5f);

        System.out.println(nombre);
        System.out.println(temp);

        // Bag

        Bag<String> bolsa1 = new HashBag<>();
        Bag<Caja<String>> bolsa2 = new HashBag<>();

        bolsa1.add("Manzana", 3);
        bolsa1.add("Uva");
        bolsa1.add("Pera", 2);
        bolsa1.add("Aguacate", 1);

        System.out.println(bolsa1);

        bolsa1.remove("Pera", 2);

        System.out.println(bolsa1.uniqueSet());

        // Queue

        Queue<Integer> filaCola = new LinkedList<>();

        filaCola.add(7);
        filaCola.add(12);
        filaCola.add(1);

        System.out.println("Fila: \n" + filaCola);

        while ( !filaCola.isEmpty() ){

            System.out.println("Atendiendo: " + filaCola.poll());

        }

        System.out.println("Cantidad de elementos en la fila: " + filaCola.size());

        // Stack

        Stack<Caja> pila = new Stack<>();

        pila.push(nombre);
        pila.push(temp);

        System.out.println("Cajas en la pila: \n" + pila);

        while ( pila.size() > 0 ) {

            System.out.println(pila.pop());

        }



    }

}