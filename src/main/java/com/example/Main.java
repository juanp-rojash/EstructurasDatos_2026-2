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

        // Tipos de Datos

        //Numericos Enteros
        byte varByte = 0;
        short varShort = 10;
        int varInt = 200;
        long varLong = 28890;

        //Numericos Decimales
        float varFloat = 0.8f;
        double varDouble = 0.00008;

        //Palbras - Oraciones
        String nombreUsuario = "Carlos";

        //Caracteres
        char caracter = 'E';

        boolean esMayor = true;

        //Exponer Datos
        System.out.println("Mensaje por consola");

        //Solicitar Datos
        Scanner sc = new Scanner(System.in);

        String cedulaUsuario = "";
        int edadUsuario = 0;

        System.out.print("Ingrese la CC: ");
        cedulaUsuario = sc.nextLine();

        System.out.print("Ingrese la edad: ");
        edadUsuario = sc.nextInt();
        sc.nextLine();

        //Conversion de Datos
        //short cedulaNumerica = Short.parseShort(cedulaUsuario);
        int cedulaNumerica = Integer.parseInt(cedulaUsuario);
        float cedulaDecimal = Float.parseFloat(cedulaUsuario);

        //Casteo
        byte varCastByte = (byte) varLong;

        //Condiciones
        // Operadores and -> && - or -> ||
        if ( edadUsuario <= 17 && edadUsuario >= 10) {
            System.out.println("No entra fiesta");
        }
        else if ( edadUsuario >= 90 ){
            System.out.println("Cuidado");
        }
        else{
            System.out.println("Entra a la fiesta");
        }

        short dado = 3;

        switch ( dado ){

            case 1:
                System.out.println("Cara del dado 1");
                break;
            case 2:
                System.out.println("Cara del dado 2");
                break;
            default:
                System.out.println("Cara invalida");

        }

        // Ciclos

        // For

        for (int i = 0 ; i <= 100; i++){
            System.out.println(i);
        }

        // while

        while ( true ){

            if ( varInt == 200 ) break;

        }

        int i = 0;

        while ( i <= 100 ){

            i++;

        }

        // do - while

        do{
            System.out.println("Ejecucion inicial");
        }while(false);

        // Estructuras de Datos Basicas

        // Vector

        int [] x = new int[4];

        x[1] = 34;

        // Matriz

        float [][] matriz = new float[5][5];

        try {

            File archivo = new File("");
            FileReader archivoLectura = new FileReader(archivo);
            BufferedReader datosArchivo = new BufferedReader(archivoLectura);

            String linea = "";
            String [] lineaSeparada;
            while((linea = datosArchivo.readLine()) != null){

                lineaSeparada = linea.split(";");


            }

            datosArchivo.close();

            // Auxiliar:

            /*
            try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
                System.out.println(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
             */

            Vehiculo v1 = new Camioneta("", "", "", "");

            ArrayList<Vehiculo> taller = new ArrayList<>();

            taller.add(v1);

        }
        catch (IOException io) {

        }
        catch (Exception e){

        }

    }

}