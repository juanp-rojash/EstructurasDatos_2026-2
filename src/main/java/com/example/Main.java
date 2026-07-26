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

            // 1. Creamos el mapper de Jackson para convertir JSON a objetos Java.
            ObjectMapper mapper = new ObjectMapper();

            // 2. Leemos el archivo JSON desde resources.
            InputStream inputstreamlista = Main.class.getResourceAsStream("/Dummy/pedidos.json");

            // 3. Usamos TypeReference para indicar que el JSON contiene una lista de PedidoDTO.
            //    Así Jackson sabe que debe convertir el contenido a un List<PedidoDTO>.
            List<PedidoDTO> listaDtos = mapper.readValue(inputstreamlista, new TypeReference<List<PedidoDTO>>() {});

            // 4. Transformamos cada DTO a nuestro modelo de negocio.
            List<Pedido> listaModelo = listaDtos.stream().map(PedidoDTO::DTO_Modelo).toList();

            // 5. Para serializar, convertimos la lista de pedidos a JSON y la mostramos.
            //    Este paso es el inverso de la deserialización.
            String jsonSerializado = mapper.writeValueAsString(listaModelo);
            System.out.println("\n===== JSON SERIALIZADO =====\n");
            System.out.println(jsonSerializado);

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