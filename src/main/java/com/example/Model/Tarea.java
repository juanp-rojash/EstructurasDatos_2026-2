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

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tarea o) {

        int r = 0;

        if (descripcion.equals("VIP") && !o.getDescripcion().equals("VIP")){

            return -1;

        }

        r = Integer.compare(prioridad, o.getPrioridad());

        if ( r != 0 ) return r;

        r = fechaIngreso.compareTo(o.getFechaIngreso());

        return r;

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
