package com.example;

import com.example.DTO.PedidoDTO;
import com.example.Model.Pedido;
import com.example.Service.PedidoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream inputstreamlista = Main.class.getResourceAsStream("/Dummy/pedidos.json");

            List<PedidoDTO> listaDtos = mapper.readValue(inputstreamlista, new TypeReference<List<PedidoDTO>>() {});

            List<Pedido> listaModelo = listaDtos.stream().map(PedidoDTO::DTO_Modelo).toList();

            // Crear el servicio
            PedidoService pedidoService = new PedidoService(listaModelo);

            System.out.println("===== TODOS LOS PEDIDOS =====\n");
            for (Pedido p : listaModelo) {
                System.out.println(p);
            }

            // Ejemplo: Obtener pedidos de un usuario específico
            String identificacionBuscar = "1001234567";
            System.out.println("\n===== PEDIDOS DEL USUARIO: " + identificacionBuscar + " =====\n");
            List<Pedido> pedidosUsuario = pedidoService.obtenerPedidosPorUsuario(identificacionBuscar);
            
            for (Pedido p : pedidosUsuario) {
                System.out.println(p);
            }

            // Calcular total
            float totalUsuario = pedidoService.calcularTotalPedidos(pedidosUsuario);
            System.out.println("\nTotal de pedidos: $" + totalUsuario);

            // Total general
            System.out.println("\n===== TOTAL GENERAL DE PEDIDOS =====\n");
            float totalGeneral = pedidoService.calcularTotalPedidos(listaModelo);
            System.out.println("Total general: $" + totalGeneral);

        }
        catch (Exception e) {
            System.out.println("Error del sistema: " + e);
        }

    }

}