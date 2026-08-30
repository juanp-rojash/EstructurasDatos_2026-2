package com.example;


import com.example.Model.Lista;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {


        Queue<String> listaEnlazada = new LinkedList<>();
        Queue<String> array = new ArrayDeque<>();

        Deque<Integer> listaEnlazada2 = new LinkedList<>();
        Deque<Integer> array2 = new ArrayDeque<>();

        Lista<String> estudiantes = new Lista<>();

        estudiantes.add("Carlos");
        estudiantes.add("Maicol");
        estudiantes.add("Fredy");

        System.out.println(estudiantes);

    }

}