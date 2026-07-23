package com.example.Model;

public class Camioneta extends Vehiculo {

    private String TipoCombustion;


    public Camioneta(String placa, String modelo, String color, String tipoCombustion) {
        super(placa, modelo, color);
        TipoCombustion = tipoCombustion;
    }

    @Override
    public String acelerar(int velocidad) {
        return "";
    }

    @Override
    public String frenar() {
        return "";
    }
}
