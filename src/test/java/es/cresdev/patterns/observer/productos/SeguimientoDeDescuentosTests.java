package es.cresdev.patterns.observer.productos;

import es.cresdev.patterns.observer.productos.observadores.SeguimientoDeDescuentos;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class SeguimientoDeDescuentosTests {

    @Test
    void registraDescuentoCuandoPrecioBaja() {
        SeguimientoDeDescuentos obs = new SeguimientoDeDescuentos();
        obs.notificarPrecio(200.0f, 150.0f);
        assertEquals("Descuento aplicado: antes 200.0 ahora 150.0", obs.getUltimaNotificacion());
    }

    @Test
    void noRegistraDescuentoCuandoPrecioSube() {
        SeguimientoDeDescuentos obs = new SeguimientoDeDescuentos();
        obs.notificarPrecio(100.0f, 120.0f);
        assertNull(obs.getUltimaNotificacion());
    }

    @Test
    void ignoraNotificacionDeStock() {
        SeguimientoDeDescuentos obs = new SeguimientoDeDescuentos();
        obs.notificarStock(10, 5);
        assertNull(obs.getUltimaNotificacion());
    }
}

