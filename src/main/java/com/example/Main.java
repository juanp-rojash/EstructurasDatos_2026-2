package com.example;


import com.example.Model.LinkedSimpleList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();

        Queue<String> queue = new LinkedList<>();

        deque.add("Elemento");
        deque.offer("2");

        queue.add("Dato");

        LinkedSimpleList<String> listaSimple = new LinkedSimpleList<>();

        listaSimple.add("Dato Uno");
        listaSimple.add("Dato Dos");
        listaSimple.add("Dato Tres");

        System.out.println(listaSimple);

    }

}