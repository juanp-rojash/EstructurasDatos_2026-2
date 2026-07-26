package com.example.Service;

import com.example.Model.Pedido;
import com.example.Model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas unitarias para PedidoService")
class PedidoServiceTest {

    private PedidoService pedidoService;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private List<Pedido> listaPedidos;

    @BeforeEach
    void setUp() {
        // Crear usuarios de prueba
        usuario1 = new Usuario("1001234567", "Ana Rodríguez");
        usuario2 = new Usuario("1002345678", "Carlos Méndez");
        usuario3 = new Usuario("1003456789", "Laura Torres");

        // Crear lista de pedidos
        listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedido(usuario1, 150000.0f));
        listaPedidos.add(new Pedido(usuario1, 75000.0f));
        listaPedidos.add(new Pedido(usuario2, 320000.5f));
        listaPedidos.add(new Pedido(usuario3, 98000.75f));
        listaPedidos.add(new Pedido(usuario1, 50000.0f));

        // Inicializar el servicio con la lista de pedidos
        pedidoService = new PedidoService(listaPedidos);
    }

    @Test
    @DisplayName("Debe obtener todos los pedidos de un usuario por su identificación")
    void testObtenerPedidosPorUsuario() {
        // Arrange
        String identificacionUsuario = "1001234567";
        int expectedCount = 3;

        // Act
        List<Pedido> pedidosObtenidos = pedidoService.obtenerPedidosPorUsuario(identificacionUsuario);

        // Assert
        assertEquals(expectedCount, pedidosObtenidos.size(), 
            "El usuario debe tener exactamente 3 pedidos");
        
        for (Pedido pedido : pedidosObtenidos) {
            assertEquals(usuario1, pedido.getCliente(), 
                "Todos los pedidos obtenidos deben pertenecer a Ana Rodríguez");
        }
    }

    @Test
    @DisplayName("Debe retornar lista vacía cuando no hay pedidos para un usuario")
    void testObtenerPedidosPorUsuarioNoExistente() {
        // Arrange
        String identificacionUsuario = "9999999999";

        // Act
        List<Pedido> pedidosObtenidos = pedidoService.obtenerPedidosPorUsuario(identificacionUsuario);

        // Assert
        assertTrue(pedidosObtenidos.isEmpty(), 
            "Debe retornar una lista vacía para un usuario sin pedidos");
    }

    @Test
    @DisplayName("Debe comparar correctamente los pedidos de un usuario específico")
    void testCompararPedidosDeUsuario() {
        // Arrange
        String identificacion = "1002345678";
        Usuario usuarioEsperado = usuario2;
        float precioEsperado = 320000.5f;

        // Act
        List<Pedido> pedidosDelUsuario = pedidoService.obtenerPedidosPorUsuario(identificacion);

        // Assert
        assertFalse(pedidosDelUsuario.isEmpty(), "Debe haber al menos un pedido");
        Pedido primerPedido = pedidosDelUsuario.get(0);
        
        assertEquals(usuarioEsperado, primerPedido.getCliente(), 
            "El cliente debe ser Carlos Méndez");
        assertEquals(precioEsperado, primerPedido.getPrecio(), 
            "El precio debe coincidir exactamente");
    }

    @Test
    @DisplayName("Debe calcular correctamente el total de precios de un listado de pedidos")
    void testCalcularTotalPedidos() {
        // Arrange
        List<Pedido> listaPedidosPrueba = new ArrayList<>();
        listaPedidosPrueba.add(new Pedido(usuario1, 100000.0f));
        listaPedidosPrueba.add(new Pedido(usuario2, 50000.0f));
        listaPedidosPrueba.add(new Pedido(usuario3, 25000.0f));
        
        float totalEsperado = 175000.0f;

        // Act
        float totalCalculado = pedidoService.calcularTotalPedidos(listaPedidosPrueba);

        // Assert
        assertEquals(totalEsperado, totalCalculado, 0.01f, 
            "El total debe ser la suma de todos los precios");
    }

    @Test
    @DisplayName("Debe calcular el total correcto para los pedidos de un usuario específico")
    void testTotalPedidosDelUsuario() {
        // Arrange
        String identificacion = "1001234567";
        float totalEsperado = 275000.0f; // 150000 + 75000 + 50000

        // Act
        List<Pedido> pedidosDelUsuario = pedidoService.obtenerPedidosPorUsuario(identificacion);
        float totalCalculado = pedidoService.calcularTotalPedidos(pedidosDelUsuario);

        // Assert
        assertEquals(totalEsperado, totalCalculado, 0.01f, 
            "El total de pedidos de Ana Rodríguez debe ser 275000");
        assertEquals(3, pedidosDelUsuario.size(), 
            "Ana Rodríguez debe tener 3 pedidos");
    }

    @Test
    @DisplayName("Debe retornar 0 al calcular el total de una lista vacía")
    void testCalcularTotalPedidosVacia() {
        // Arrange
        List<Pedido> listaVacia = new ArrayList<>();
        float totalEsperado = 0.0f;

        // Act
        float totalCalculado = pedidoService.calcularTotalPedidos(listaVacia);

        // Assert
        assertEquals(totalEsperado, totalCalculado, 
            "El total de una lista vacía debe ser 0");
    }

    @Test
    @DisplayName("Debe calcular el total de todos los pedidos del sistema")
    void testTotalTodosPedidosSistema() {
        // Arrange
        float totalEsperado = 150000.0f + 75000.0f + 320000.5f + 98000.75f + 50000.0f;

        // Act
        List<Pedido> todosPedidos = pedidoService.obtenerTodosPedidos();
        float totalCalculado = pedidoService.calcularTotalPedidos(todosPedidos);

        // Assert
        assertEquals(totalEsperado, totalCalculado, 0.01f, 
            "El total de todos los pedidos debe ser la suma correcta");
        assertEquals(5, todosPedidos.size(), 
            "Debe haber 5 pedidos en total");
    }

    @Test
    @DisplayName("Debe validar que los pedidos de diferentes usuarios sean distintos")
    void testPedidosDiferenteUsuariosDistintos() {
        // Arrange
        String idUsuario1 = "1001234567";
        String idUsuario2 = "1002345678";

        // Act
        List<Pedido> pedidosUsuario1 = pedidoService.obtenerPedidosPorUsuario(idUsuario1);
        List<Pedido> pedidosUsuario2 = pedidoService.obtenerPedidosPorUsuario(idUsuario2);

        // Assert
        assertNotEquals(pedidosUsuario1.size(), pedidosUsuario2.size(), 
            "Los usuarios deben tener diferente cantidad de pedidos");
        
        for (Pedido p1 : pedidosUsuario1) {
            for (Pedido p2 : pedidosUsuario2) {
                assertNotEquals(p1.getCliente(), p2.getCliente(), 
                    "Los clientes deben ser diferentes");
            }
        }
    }

    @Test
    @DisplayName("Debe mantener la precisión decimal al calcular totales")
    void testPrecisionDecimalTotales() {
        // Arrange
        List<Pedido> listaPrecision = new ArrayList<>();
        listaPrecision.add(new Pedido(usuario1, 100.50f));
        listaPrecision.add(new Pedido(usuario2, 200.75f));
        listaPrecision.add(new Pedido(usuario3, 50.25f));
        
        float totalEsperado = 351.50f;

        // Act
        float totalCalculado = pedidoService.calcularTotalPedidos(listaPrecision);

        // Assert
        assertEquals(totalEsperado, totalCalculado, 0.01f, 
            "Debe mantener precisión en decimales");
    }
}
