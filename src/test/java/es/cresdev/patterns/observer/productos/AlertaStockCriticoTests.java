package es.cresdev.patterns.observer.productos;

import es.cresdev.patterns.observer.productos.observadores.AlertaStockCritico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AlertaStockCriticoTests {

    @Test
    void alertaGeneradaCuandoStockEsMenorQueCinco() {
        AlertaStockCritico obs = new AlertaStockCritico();
        obs.notificarStock(10, 4);
        assertEquals("⚠️ Alerta: stock crítico (4 unidades)", obs.getUltimaNotificacion());
    }

    @Test
    void noSeGeneraAlertaCuandoStockEsCinco() {
        AlertaStockCritico obs = new AlertaStockCritico();
        obs.notificarStock(10, 5);
        assertNull(obs.getUltimaNotificacion());
    }

    @Test
    void ignoraNotificacionDePrecio() {
        AlertaStockCritico obs = new AlertaStockCritico();
        obs.notificarPrecio(100, 90);
        assertNull(obs.getUltimaNotificacion());
    }
}

