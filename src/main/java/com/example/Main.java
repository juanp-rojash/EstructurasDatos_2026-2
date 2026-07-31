package com.example;

import com.example.DTO.PedidoDTO;
import com.example.Model.Pedido;
import com.example.Service.PedidoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        try{

            // ObjectMapper es la clase encargada de convertir JSON a objetos Java.
            ObjectMapper mapper = new ObjectMapper();

            // Se lee el archivo JSON desde los recursos del proyecto.
            InputStream inputStream = Main.class.getResourceAsStream("/Dummy/datos_ejemplo.json");

            // Se deserializa el JSON a una lista de DTOs.
            // Cada elemento del JSON se transforma en un objeto PedidoDTO.
            List<PedidoDTO> listaPedidoDTO = mapper.readValue(inputStream, new TypeReference<List<PedidoDTO>>(){});

            // Se convierte cada DTO a un objeto de dominio o modelo de negocio.
            List<Pedido> listaPedido = listaPedidoDTO.stream().map(PedidoDTO::DTO_Modelo).toList();

            listaPedido.forEach(System.out::println);

            // Se usa el servicio para filtrar los pedidos del cliente con identificación 123456789.
            List<Pedido> pedidosAna = PedidoService.identificarPedidosCliente(listaPedido, "123456789");

            System.out.println("===");

            pedidosAna.forEach(System.out::println);

        }
        catch (Exception e){

            // Si ocurre algún problema en la lectura o conversión del JSON, se muestra el error.
            System.out.println("Error: " + e);

        }

    }

}