package com.example.Service;

import com.example.Model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    public static List<Pedido> identificarPedidosCliente ( List<Pedido> listaPedido ,String identificacion ){

        List<Pedido> resultado = new ArrayList<>();

        for (Pedido p : listaPedido){

            if ( p.getCliente().getIdentificacion().equals(identificacion) ){

                resultado.add(p);

            }

        }

        return resultado;

    }

}
