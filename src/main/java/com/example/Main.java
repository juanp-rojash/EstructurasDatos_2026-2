package com.example;

import com.example.Model.Personaje;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Main {

    public static void main(String[] args) {

        try{

            File rutaArchivo = new File("src/main/resources/personaje.txt");
            FileReader archivoLectura = new FileReader(rutaArchivo);
            BufferedReader datosArchivo = new BufferedReader(archivoLectura);

            List<Personaje> personaje = new ArrayList<>();

            String dato;
            String [] datoSeparado;

            while ( ( dato = datosArchivo.readLine() ) != null ){

                datoSeparado = dato.split(";");

                if ( datoSeparado.length != 6 ){
                    log.warn("Linea del archivo con longitud invalida");
                    continue;
                }

                int id = Integer.parseInt(datoSeparado[ 0 ]);
                String name = datoSeparado[1];
                String ki = datoSeparado[2];
                String race = datoSeparado[3];
                String gener = datoSeparado[4];
                String image = datoSeparado[5];

                Personaje p = new Personaje(id, name, ki, race, gener, image);

                log.info("Creacion de objeto {}", p);

                personaje.add(p);

            }


        }
        catch (IOException io){
            log.error("Error en la entrada: " + io);
        }
        catch (Exception e) {
            log.error("Error en el sistema: " + e);
        }

    }

}