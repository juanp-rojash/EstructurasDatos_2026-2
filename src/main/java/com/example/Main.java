package com.example;

import com.example.Model.Cliente;
import com.example.Model.Pedido;
import com.example.Service.AlgoritmoCarga;
import com.example.Util.PerformanceReporter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    public static void main(String[] args) {

        /*Pedido p = new Pedido(1, 10000f);
        Cliente c = new Cliente(1, p);

        PerformanceReporter.medirPesoObjeto(p, "Pedido");
        PerformanceReporter.medirPesoObjeto(c, "Cliente");

        PerformanceReporter.reportarMemoriaSistema();

        AlgoritmoCarga.multiplicacionMatrices(8000, "Peor");*/

        int [] v = new int[2000];

        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * (1000000 - 1 + 1)) + 1;
        }

        algoritmoLineal(v);

    }

    public static void algoritmoLineal(int[] arr) {

        long startTime = System.nanoTime();

        int contador = 0;

        int suma = 0;

        for (int i = 0; i < arr.length; i++) {

            suma += arr[i];

            contador++;

        }

        long endTime = System.nanoTime();

        System.out.println("O(N) - Iteraciones: " + contador);

        System.out.println("Tiempo: " + (endTime - startTime) + " ns");

    }

}