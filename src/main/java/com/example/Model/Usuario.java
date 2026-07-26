package com.example.Model;

import java.util.Objects;

public class Usuario {

    private String identificacion;
    private String nombre;

    public Usuario(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "identificacion ='" + identificacion + '\'' +
                ", nombre ='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Usuario usuario = (Usuario) object;
        return Objects.equals(identificacion, usuario.identificacion) && Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificacion, nombre);
    }
}
