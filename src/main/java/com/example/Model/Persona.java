package com.example.Model;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private String Nombre;
    private int RangoEmergencia;

    public Persona(String nombre, int rangoEmergencia) {
        Nombre = nombre;
        RangoEmergencia = rangoEmergencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getRangoEmergencia() {
        return RangoEmergencia;
    }

    @Override
    public int compareTo(Persona otra){

        int resultado = 0;

        resultado = Integer.compare(RangoEmergencia, otra.getRangoEmergencia());

        return resultado;

    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", RangoEmergencia=" + RangoEmergencia +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Persona persona)) return false;
        return RangoEmergencia == persona.RangoEmergencia && Objects.equals(Nombre, persona.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, RangoEmergencia);
    }

}
