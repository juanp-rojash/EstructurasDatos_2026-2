package com.example;

import java.util.Objects;

public class Persona {

    private int Id;
    private String Nombre;
    private int Edad;

    public Persona(int id, String nombre, int edad) {
        Id = id;
        Nombre = nombre;
        Edad = edad;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Persona persona)) return false;
        return Id == persona.Id && Edad == persona.Edad && Objects.equals(Nombre, persona.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Nombre);
    }

}
