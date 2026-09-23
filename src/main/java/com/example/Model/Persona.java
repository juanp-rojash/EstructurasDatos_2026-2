package com.example.Model;

import java.util.Objects;

public class Persona implements Comparable<Persona>{

    private String nombre;
    private int rangoEmergencia;

    public Persona(String Nombre, int RangoEmergencia){

        nombre = Nombre;
        rangoEmergencia = RangoEmergencia;

    }

    public String getNombre() {
        return nombre;
    }

    public int getRangoEmergencia() {
        return rangoEmergencia;
    }

    @Override
    public int compareTo(Persona otra){

        int resultado = 0;

        resultado = Integer.compare(rangoEmergencia, otra.rangoEmergencia);

        return resultado;

    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rangoEmergencia=" + rangoEmergencia +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Persona persona)) return false;
        return rangoEmergencia == persona.rangoEmergencia && Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, rangoEmergencia);
    }
}
