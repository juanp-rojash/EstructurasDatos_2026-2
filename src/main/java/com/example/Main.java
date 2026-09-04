package com.example;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        int [] vector = new int[100_000_000];

        vector[75_000_000] = 99;

        int datoBuscar = 99;

        // Paso #1 Abrir recursos de los hilos
        /*try ( ExecutorService executor = Executors.newFixedThreadPool(2) ){

            // Paso #2 Proyección
            Callable<Boolean> hilo1 = () -> identificarNumero(vector, datoBuscar, 0, vector.length / 2);
            Callable<Boolean> hilo2 = () -> identificarNumero(vector, datoBuscar, vector.length / 2, vector.length);

            // Paso #3 Ejecución Plan

            long inicio = System.currentTimeMillis();

            Future<Boolean> resultado1 = executor.submit(hilo1);
            Future<Boolean> resultado2 = executor.submit(hilo2);

            boolean datoEncotrado = resultado1.get() || resultado2.get();

            long fin = System.currentTimeMillis();

            System.out.println("¿Dato Encontrado? R/ " + datoEncotrado);
            System.out.println("Tiempo de Ejecucion: " + (fin - inicio) + " ms");

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        long inicio = System.currentTimeMillis();

        boolean datoEncotrado = identificarNumero(vector, datoBuscar, 0, vector.length);

        long fin = System.currentTimeMillis();

        System.out.println("¿Dato Encontrado? R/ " + datoEncotrado);
        System.out.println("Tiempo de Ejecucion: " + (fin - inicio) + " ms");

    }

    public static boolean identificarNumero ( int [] v, int objetivo, int inicio, int fin ){

        for (int i = inicio; i < fin; i++) {

            if ( v[i] == objetivo ){
                return true;
            }

            v[i] = (int) Math.hypot(v[i], i);

        }

        return  false;

    }

}