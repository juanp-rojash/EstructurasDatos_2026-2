package com.example;

import com.example.Model.Persona;
import com.example.Model.Tarea;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) {

        //Colas prioridad minima

        PriorityQueue<Integer> colaPrioridadMin = new PriorityQueue<>();

        colaPrioridadMin.add(12);
        colaPrioridadMin.add(17);
        colaPrioridadMin.add(10);
        colaPrioridadMin.add(15);
        colaPrioridadMin.add(7);

        System.out.println("Cola de prioridad minima: ");
        System.out.println(colaPrioridadMin);

        System.out.println("Primer elemento menor de la cola: " + colaPrioridadMin.remove());

        System.out.println(colaPrioridadMin);

        //Colas prioridad maxima

        PriorityQueue<Integer> colaPrioridadMax = new PriorityQueue<>(Collections.reverseOrder());

        colaPrioridadMax.add(2);
        colaPrioridadMax.add(3);
        colaPrioridadMax.add(12);
        colaPrioridadMax.add(8);
        colaPrioridadMax.add(21);

        System.out.println("Cola de prioridad maxima: ");
        System.out.println(colaPrioridadMax);

        System.out.println(colaPrioridadMax.remove());
        System.out.println(colaPrioridadMax.remove());

        System.out.println(colaPrioridadMax);

        //Cola prioridad pacientes

        PriorityQueue<Persona> pacienteUrgencia = new PriorityQueue<>();

        pacienteUrgencia.add(new Persona("Fredy", 9));
        pacienteUrgencia.add(new Persona("Maicol", 1));
        pacienteUrgencia.add(new Persona("Angie", 8));
        pacienteUrgencia.add(new Persona("Santi", 5));

        int contadorAtendido = 1;

        while(!pacienteUrgencia.isEmpty()){

            System.out.println("Turno #:" + contadorAtendido++ + " - " + pacienteUrgencia.remove());

        }

        //Colas prioridad Tareas - Multiple Prioridad

        PriorityQueue<Tarea> kanban = new PriorityQueue<>();

        kanban.add(new Tarea("Parcial IA", 5, LocalDateTime.now().minusMinutes(2)));
        kanban.add(new Tarea("Descansar", 1, LocalDateTime.now().minusMinutes(3)));
        kanban.add(new Tarea("Comprar arena gatos", 3, LocalDateTime.now().minusMinutes(3)));
        kanban.add(new Tarea("Estudiar Ingles", 5, LocalDateTime.now().minusMinutes(90)));
        kanban.add(new Tarea("Video Etica", 7, LocalDateTime.now().minusMinutes(9)));

        contadorAtendido = 1;

        while(!kanban.isEmpty()){

            System.out.println("Turno #:" + contadorAtendido++ + " - " + kanban.remove());

        }

    }


}