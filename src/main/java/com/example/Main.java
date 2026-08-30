package com.example;

import com.example.Model.Cliente;
import com.example.Model.Pedido;
import com.example.Service.AlgoritmoDeCarga;
import com.example.Util.PerformanceReporter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
public class Main {

    private static final Logger loggerTiempos = LogManager.getLogger( "tiempos" );

    public static void main(String[] args) {

        /*Pedido p = new Pedido(1, 10000f);

        PerformanceReporter.medirPesoObjeto(p, "Pedido");

        Cliente c = new Cliente(1, p);

        PerformanceReporter.medirPesoObjeto(c, "Cliente");

        PerformanceReporter.reportarMemoriaSistema();

        AlgoritmoDeCarga.multiplicacionMatrices(100, "MEJOR");
        AlgoritmoDeCarga.multiplicacionMatrices(500, "PROMEDIO");
        AlgoritmoDeCarga.multiplicacionMatrices(1000, "PEOR");*/

        int [] v = new int[2000];
        int [] v2 = new int[1000000];

        for (int i = 0; i < v.length; i++) {
            v[i] = (int) (Math.random() * ((2000 - 1) + 1)) + 1;
        }

        for (int i = 0; i < v2.length; i++) {
            v2[i] = (int) (Math.random() * ((2000 - 1) + 1)) + 1;
        }

        long inicioTiempoProceso = System.nanoTime();
        algoritmoLineal(v);
        double tiempoTotal = (System.nanoTime() - inicioTiempoProceso) / 1_000_000_000.0;

        loggerTiempos.info("algoritmoLineal = " + tiempoTotal + "s");

        algoritmoLineal(v2);

    }

    public static void algoritmoLineal(int[] arr) {

        long startTime = System.currentTimeMillis();

        int contador = 0;

        int suma = 0;

        for (int i = 0; i < arr.length; i++) {

            suma += arr[i];

            contador++;

        }

        long endTime = System.currentTimeMillis();

        System.out.println("O(N) - Iteraciones: " + contador);

        System.out.println("Tiempo: " + (endTime - startTime) + " ms");

    }

}