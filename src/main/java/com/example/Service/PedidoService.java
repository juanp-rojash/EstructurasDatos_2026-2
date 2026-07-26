package com.example.Service;

import com.example.Model.Pedido;
import com.example.Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private List<Pedido> pedidos;

    public PedidoService(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Obtiene todos los pedidos asociados a un usuario específico por su identificación
     *
     * @param identificacion la identificación del usuario
     * @return lista de pedidos del usuario, o lista vacía si no hay pedidos
     */
    public List<Pedido> obtenerPedidosPorUsuario(String identificacion) {
        List<Pedido> pedidosUsuario = new ArrayList<>();
        
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getIdentificacion().equals(identificacion)) {
                pedidosUsuario.add(pedido);
            }
        }
        
        return pedidosUsuario;
    }

    /**
     * Calcula el total del precio de un listado de pedidos
     *
     * @param listaPedidos lista de pedidos a totalizar
     * @return suma total de los precios de los pedidos
     */
    public float calcularTotalPedidos(List<Pedido> listaPedidos) {
        float total = 0.0f;
        
        for (Pedido pedido : listaPedidos) {
            total += pedido.getPrecio();
        }
        
        return total;
    }

    /**
     * Obtiene todos los pedidos
     *
     * @return lista de todos los pedidos
     */
    public List<Pedido> obtenerTodosPedidos() {
        return new ArrayList<>(pedidos);
    }
}
