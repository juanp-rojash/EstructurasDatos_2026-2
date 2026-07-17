package com.example.Model;

public class Camioneta extends Vehiculo {

    private String Combustion;

    public Camioneta(String placa, String modelo, String color, String combustion) throws Exception {
        super(placa, modelo, color);
        Combustion = combustion;
    }

    @Override
    public String acelerar() {
        return "";
    }

    @Override
    public String frenar() {
        return "";
    }



}
