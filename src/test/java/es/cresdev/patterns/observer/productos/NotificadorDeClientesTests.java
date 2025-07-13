package es.cresdev.patterns.observer.productos;

import es.cresdev.patterns.observer.productos.observadores.NotificadorDeClientes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class NotificadorDeClientesTests {

    @Test
    void notificaSiStockPasaDeCeroAPositivo() {
        NotificadorDeClientes obs = new NotificadorDeClientes();
        obs.notificarStock(0, 10);
        assertEquals("🛒 Producto ahora disponible (stock: 10)", obs.getUltimaNotificacion());
    }

    @Test
    void noNotificaSiStockNoVieneDeCero() {
        NotificadorDeClientes obs = new NotificadorDeClientes();
        obs.notificarStock(5, 15);
        assertNull(obs.getUltimaNotificacion());
    }

    @Test
    void notificaSiPrecioBaja() {
        NotificadorDeClientes obs = new NotificadorDeClientes();
        obs.notificarPrecio(100.0f, 80.0f);
        assertEquals("💰 Nuevo precio con descuento: 80.0", obs.getUltimaNotificacion());
    }

    @Test
    void noNotificaSiPrecioSube() {
        NotificadorDeClientes obs = new NotificadorDeClientes();
        obs.notificarPrecio(80.0f, 100.0f);
        assertNull(obs.getUltimaNotificacion());
    }
}

