package com.example;

import com.example.Model.Camioneta;
import com.example.Model.Vehiculo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Tipos de datos

        // Numericos Enteros
        byte varByte = 0;
        short varCorta = 10;
        int varInt = 100;
        long varLarga = 10000;

        // Numericos Decimales
        float varDecimal = 0.5f;
        double varDouble = 0.0009;

        // Oraciones
        String palabra = "Oracion";
        char caracteres = 'A';

        // Booleanos
        boolean  esMayorEdad = true;

        // Exponer
        System.out.println("Exponer info por consola");

        // Solicitar Información
        Scanner sc = new Scanner(System.in);

        String cedulaUsuario = "";
        int edadUsuario = 0;

        System.out.print("Ingrese la cedula: ");
        cedulaUsuario = sc.nextLine();

        System.out.print("Ingrese la edad: ");
        edadUsuario = sc.nextInt();
        sc.nextLine();

        // Conversiones

        // Parseo
        int dato = Integer.parseInt(cedulaUsuario);
        short datoShort = Short.parseShort(cedulaUsuario);
        float datoFloat = Float.parseFloat(cedulaUsuario);

        // Casteo

        long datoLargo = 10000;
        byte datoByte = (byte) datoLargo;

        // Concatenacion

        String nombre = "Luis";
        String apellido = "Castro";

        String nombreCompleto = nombre + " " + apellido;

        // Condiciones
        // and = && - or ||
        if(edadUsuario <= 17 && edadUsuario >= 10){
            System.out.println("No entra disco");
        }
        else if(edadUsuario >= 90){
            System.out.println("Mucho cuidado");
        }
        else{
            System.out.println("Entra a la disco");
        }

        System.out.println("¿Cual es la mejor disco?");
        String disco = sc.nextLine().toLowerCase();

        switch (disco){
            case "tutaina":
                System.out.println("Top 3");
                break;
            case "julieta":
                System.out.println("Top 1");
                break;
            default:
                System.out.println("No selecciono");
        }

        // For

        for ( int i = 1; i <= 100; i++){

            System.out.println(i);

        }

        // while

        while ( true ){

            if ( true ) break;

        }

        int i = 0;

        while ( i <= 100 ){

            System.out.println(i++);

        }

        do{

            System.out.println("Primera ejecución");

        }while( false );


        // Listas en Java

        ArrayList<String> estudiantes = new ArrayList<String>();

        estudiantes.add("A");
        estudiantes.add("B");
        estudiantes.add("C");

        for ( String estudiante : estudiantes ){

            System.out.println(estudiante);

        }

        // Programación funcional - Stream


        // Vector

        int [] vector = new int[10];

        vector[6] = 45;

        for ( int x = 0 ; x < vector.length ; x++ ){
            System.out.println(vector[x]);
        }

        String [] [] listaEstudiantes = new String [2] [3] ;

        listaEstudiantes[0][1] = "Luis";

        try{

            File rutaArchivo = new File("");
            FileReader archivoLectura = new FileReader(rutaArchivo);
            BufferedReader datos = new BufferedReader(archivoLectura);

            String lineaArchivo = "";
            String [] lineaSeparada;


            while ( (lineaArchivo = datos.readLine()) != null ){

                lineaSeparada = lineaArchivo.split(";");

            }

            Camioneta c1 = new Camioneta("", "", "", "");
            Vehiculo v1 = new Camioneta("", "", "", "");


        }
        catch (IOException io){
            System.out.println("Error en el recurso de archivo: " + io);
        }
        catch (Exception e){
            System.out.println("Error generico: " + e);
        }


    }

}