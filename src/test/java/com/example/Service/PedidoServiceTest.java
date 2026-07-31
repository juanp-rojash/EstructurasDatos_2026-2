package com.example.Service;

import com.example.Model.Pedido;
import com.example.Model.Usuario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PedidoServiceTest {

    @Test
    void identificarPedidosCliente_debeRetornarSoloLosPedidosDelClienteBuscado() throws Exception {
        Usuario cliente1 = new Usuario("Ana", "123");
        Usuario cliente2 = new Usuario("Luis", "456");

        Pedido pedido1 = new Pedido(cliente1, 100.0f);
        Pedido pedido2 = new Pedido(cliente2, 250.0f);
        Pedido pedido3 = new Pedido(cliente1, 75.5f);

        List<Pedido> resultado = PedidoService.identificarPedidosCliente(
                List.of(pedido1, pedido2, pedido3),
                "123"
        );

        assertEquals(2, resultado.size());
        assertTrue(resultado.stream().allMatch(p -> p.getCliente().getIdentificacion().equals("123")));
    }

    @Test
    void identificarPedidosCliente_debeRetornarListaVaciaCuandoNoExistenCoincidencias() throws Exception {
        Usuario cliente = new Usuario("Carlos", "789");
        Pedido pedido = new Pedido(cliente, 300.0f);

        List<Pedido> resultado = PedidoService.identificarPedidosCliente(
                List.of(pedido),
                "000"
        );

        assertTrue(resultado.isEmpty());
    }
}
