package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> calendario = new HashMap<>();

        calendario.put("enero", 1);
        calendario.put("febrero", 2);
        calendario.put("marzo", 3);

        System.out.println(calendario);

        System.out.println("Numero de mes Febrero: " + calendario.get("febrero"));

        System.out.println("¿Existe mes de Abril? " + calendario.containsKey("abril"));

        for ( Map.Entry<String, Integer> mes : calendario.entrySet() ){

            System.out.println(" [ " + mes.getKey() + " ] = " + mes.getValue());

        }

        ////////

        Map<Persona, String> organigrama = new HashMap<>();

        Persona p1 = new Persona(1, "Fredy", 30);
        Persona p2 = new Persona(2, "Santiago", 23);
        Persona p3 = new Persona(3, "Angelina", 42);

        organigrama.put(p1, "Gerente");
        organigrama.put(p2, "Dev");
        organigrama.put(p3, "Lider Tecnico");

        System.out.println(organigrama);

        Persona p4 = new Persona(4, "Maicol", 50);

        String vacante = organigrama.remove(p1);

        organigrama.put(p4, vacante);

        organigrama.put(p3, "Senior");

        System.out.println(organigrama);

        p2.setEdad(p2.getEdad() + 1);

        System.out.println(p2);

        System.out.println("Vacante de Santiago: " + organigrama.get(p2));


    }

}