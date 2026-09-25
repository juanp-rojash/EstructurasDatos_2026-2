package com.example;

import com.example.Model.Persona;
import com.example.Model.Tarea;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> colaMin = new PriorityQueue<>();

        colaMin.add(6);
        colaMin.add(7);
        colaMin.add(9);
        colaMin.add(3);

        System.out.println("Cola Prioridad Minima: ");
        System.out.println(colaMin);
        System.out.println("Extracción del elemento minimo: " + colaMin.remove());
        System.out.println(colaMin);

        PriorityQueue<Integer> colaMax = new PriorityQueue<>(Collections.reverseOrder());

        colaMax.add(15);
        colaMax.add(5);
        colaMax.add(4);
        colaMax.add(17);

        System.out.println("Cola Prioridad Maxima: ");
        System.out.println(colaMax);
        System.out.println("Extracción del elemento maximo: " + colaMax.remove());
        System.out.println(colaMax);

        PriorityQueue<Persona> urgencias = new PriorityQueue<>();

        urgencias.add(new Persona("Pepito", 2));
        urgencias.add(new Persona("Juancho", 7));
        urgencias.add(new Persona("Bellota", 1));

        int contador = 1;

        while ( ! urgencias.isEmpty() ){

            System.out.println("Paciente #" + contador++ + " atendido: " + urgencias.remove());

        }

        PriorityQueue<Tarea> kanban = new PriorityQueue<>();

        kanban.add(new Tarea("Taller Procesos Especiales", 4, LocalDateTime.now().minusMinutes(2)));
        kanban.add(new Tarea("Parcial Bases de Datos", 4, LocalDateTime.now().minusMinutes(60)));
        kanban.add(new Tarea("Taller Arquitector", 7, LocalDateTime.now().minusMinutes(1)));
        kanban.add(new Tarea("Parcial IA", 2, LocalDateTime.now().minusMinutes(4)));
        kanban.add(new Tarea("VIP", 20, LocalDateTime.now().minusMinutes(4)));

        int contadorTareas = 1;

        while ( ! kanban.isEmpty() ){

            System.out.println("Tarea #" + contadorTareas++ + " - " + kanban.remove());

        }

    }

}