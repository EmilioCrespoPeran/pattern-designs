package es.cresdev.patterns.observer.productos;

import es.cresdev.patterns.observer.productos.observadores.IndicadorDeReabastecimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class IndicadorDeReabastecimientoTests {

    @Test
    void detectaReabastecimientoDesdeCero() {
        IndicadorDeReabastecimiento obs = new IndicadorDeReabastecimiento();
        obs.notificarStock(0, 20);
        assertEquals("✅ Producto reabastecido: 0 -> 20", obs.getUltimaNotificacion());
    }

    @Test
    void ignoraSiStockAnteriorNoEraCero() {
        IndicadorDeReabastecimiento obs = new IndicadorDeReabastecimiento();
        obs.notificarStock(5, 15);
        assertNull(obs.getUltimaNotificacion());
    }

    @Test
    void ignoraNotificacionDePrecio() {
        IndicadorDeReabastecimiento obs = new IndicadorDeReabastecimiento();
        obs.notificarPrecio(100.0f, 90.0f);
        assertNull(obs.getUltimaNotificacion());
    }
}

