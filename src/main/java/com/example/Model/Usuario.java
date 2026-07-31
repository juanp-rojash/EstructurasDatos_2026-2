package com.example.Model;

import java.util.Objects;

public class Usuario {

    private String nombre;
    private String identificacion;

    public Usuario(String nombre, String identificacion){

        this.nombre = nombre;
        this.identificacion = identificacion;

    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "nombre = '" + nombre + '\'' +
                ", identificacion = '" + identificacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Usuario usuario)) return false;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(identificacion, usuario.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, identificacion);
    }

}
