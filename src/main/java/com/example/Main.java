package com.example;

import com.example.Model.Personaje;
import com.example.Service.Torneo;
import com.example.Util.Configuration;
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

        try {

            List<Personaje> personajes = Configuration.cargarDatos("src/main/resources/personaje.txt");

            String enfrentamientos = Torneo.crearTorneo(personajes);
            String filtroPoder = Torneo.rastrearPoder(personajes);
            String censo = Torneo.censoPeleadores(personajes);

            //System.out.println("\n\n" + enfrentamientos + "\n\n");
            //System.out.println("\n\n" + filtroPoder + "\n\n");
            //System.out.println("\n\n" + censo + "\n\n");

        } catch (Exception e) {
            log.error("Error en el sistema {}", e);
        }

    }

}