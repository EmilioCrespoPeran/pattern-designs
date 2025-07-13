package es.cresdev.patterns.observer.productos;

import es.cresdev.patterns.observer.productos.observadores.LoggerDeCambios;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class LoggerDeCambiosTests {

    @Test
    void logueaCambioDeStock() {
        LoggerDeCambios obs = new LoggerDeCambios();
        obs.notificarStock(20, 10);
        assertEquals("[LOG] Stock: 20 -> 10", obs.getUltimaNotificacion());
    }

    @Test
    void logueaCambioDePrecio() {
        LoggerDeCambios obs = new LoggerDeCambios();
        obs.notificarPrecio(150.0f, 120.0f);
        assertEquals("[LOG] Precio: 150.0 -> 120.0", obs.getUltimaNotificacion());
    }

    @Test
    void noLogueaSiStockNoCambia() {
        LoggerDeCambios obs = new LoggerDeCambios();
        obs.notificarStock(10, 10);
        assertNull(obs.getUltimaNotificacion());
    }

    @Test
    void noLogueaSiPrecioNoCambia() {
        LoggerDeCambios obs = new LoggerDeCambios();
        obs.notificarPrecio(100.0f, 100.0f);
        assertNull(obs.getUltimaNotificacion());
    }
}
