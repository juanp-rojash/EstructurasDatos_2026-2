package com.example.Service;

import com.example.Model.Personaje;
import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

@Log4j2
public class Torneo {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String crearTorneo(List<Personaje> participantes) throws Exception {

        try{

            log.info("Generación de Torneo - Cantidad de Participantes: {}", participantes.size());

            String [] lineaEnfrentamientoA;
            String [] lineaEnfrentamientoB;

            int cantidadElementosFila = 0;
            int divisorCantidadElementos = 0;
            int contadorA = 0;
            int contadorB = 0;

            String enfrentamientos = "";

            Queue<Personaje> filaPeleadores = new LinkedList<>();

            filaPeleadores.addAll(participantes);

            cantidadElementosFila = filaPeleadores.size();

            divisorCantidadElementos = (int) Math.floor(cantidadElementosFila / 2);

            lineaEnfrentamientoA = new String[divisorCantidadElementos];
            lineaEnfrentamientoB = new String[divisorCantidadElementos];

            log.info("Procesamiento de filas y posiciones");

            while(!filaPeleadores.isEmpty()){

                if(filaPeleadores.size() > divisorCantidadElementos){

                    lineaEnfrentamientoA[contadorA++]= filaPeleadores.poll().getName();

                    log.info("Peleador: {} -> Linea A", lineaEnfrentamientoA[contadorA-1]);

                }
                else if(filaPeleadores.size() <= lineaEnfrentamientoB.length){

                    lineaEnfrentamientoB[contadorB++]= filaPeleadores.poll().getName();

                    log.info("Peleador: {} -> Linea B", lineaEnfrentamientoB[contadorB-1]);

                }

            }

            enfrentamientos = alineamientoTorneo(lineaEnfrentamientoA, lineaEnfrentamientoB);

            log.info("Lineamiento final: \n\n{}\n\n", enfrentamientos);

            return enfrentamientos;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    private static String alineamientoTorneo(String[] lineaA, String[] lineaB) throws Exception {

        try {

            log.info("Generacion de alineacion");

            String enfrentamientos = "";

            for(int i = 0; i < Math.min(lineaA.length, lineaB.length); i++){

                enfrentamientos += "\n" + lineaA[i] + " VS " + lineaB[i];

            }

            return enfrentamientos;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String rastrearPoder(List<Personaje> participantes) throws Exception{

        try{

            log.info("Inicio de rastreo de poder - Cantidad de elementos: {}", participantes.size());

            String filtroLuchadores = "";

            Stack<Personaje> rastreador = new Stack<>();

            participantes
                    .stream()
                    .filter(p -> Integer.parseInt(p.getKi().replace(".", "")) >= 1_000_000)
                    .forEach(rastreador::add);

            filtroLuchadores = alineamientoFiltroPoder(rastreador);

            log.info("Peleadores filtrados por poder: \n\n{}\n\n", filtroLuchadores);

            return filtroLuchadores;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    private static String alineamientoFiltroPoder(Stack<Personaje> rastreador) throws Exception {

        try{

            log.info("Estandarizando exposicion de peleadores rastreados");

            String acumuladorPeleadoresSuperiores = "";

            Personaje luchadorAuxiliar;

            while (!rastreador.isEmpty()){

                luchadorAuxiliar = rastreador.pop();

                acumuladorPeleadoresSuperiores += "\n" + luchadorAuxiliar.getName() + "\t: " + luchadorAuxiliar.getKi();

            }

            return acumuladorPeleadoresSuperiores;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String censoPeleadores(List<Personaje> participantes) throws Exception{

        try{

            log.info("Inicio de censo");

            String informeRazas;

            Bag<String> razas = new HashBag<>();

            for( Personaje p : participantes ){

                razas.add(p.getRace());

            }

            informeRazas = "Cantidad de participantes: " + participantes.size() + "\nListado de Razas: \n" + razas.uniqueSet();

            log.info("Resultado de Censo: \n\n{}\n\n", informeRazas);

            return informeRazas;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }


}
