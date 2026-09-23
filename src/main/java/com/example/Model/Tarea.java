package com.example.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Tarea implements Comparable<Tarea>{

    private String descripcion;
    private int prioridad;
    private LocalDateTime fechaIngreso;

    public Tarea(String descripcion, int prioridad, LocalDateTime fechaIngreso) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaIngreso = fechaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public int compareTo(Tarea otra) {

        int resultado = 0;

        resultado = Integer.compare(prioridad, otra.getPrioridad());

        // compare -> Retorna = 0 Si tienen la misma prioridad

        if (resultado != 0) return resultado;

        resultado = fechaIngreso.compareTo(otra.getFechaIngreso());

        return  resultado;

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Tarea tarea)) return false;
        return prioridad == tarea.prioridad && Objects.equals(descripcion, tarea.descripcion) && Objects.equals(fechaIngreso, tarea.fechaIngreso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, prioridad, fechaIngreso);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
