package es.cresdev.patterns.state.pedido;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StatePedidoTests {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void estadoInicialDebeSerCreado() {
        assertEquals("Creado", pedido.getEstadoActual());
    }

    @Test
    void puedeTransicionarDeCreadoAPagado() {
        pedido.pagar();
        assertEquals("Pagado", pedido.getEstadoActual());
    }

    @Test
    void puedeTransicionarDePagadoAEnviado() {
        pedido.pagar();
        pedido.enviar();
        assertEquals("Enviado", pedido.getEstadoActual());
    }

    @Test
    void puedeTransicionarDeEnviadoAEntregado() {
        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
        assertEquals("Entregado", pedido.getEstadoActual());
    }

    @Test
    void puedeCancelarDesdeCreado() {
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstadoActual());
    }

    @Test
    void puedeCancelarDesdePagado() {
        pedido.pagar();
        pedido.cancelar();
        assertEquals("Cancelado", pedido.getEstadoActual());
    }

    @Test
    void noPuedeCancelarDesdeEnviado() {
        pedido.pagar();
        pedido.enviar();
        assertThrows(IllegalStateException.class, () -> pedido.cancelar());
    }

    @Test
    void noPuedeCancelarDesdeEntregado() {
        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
        assertThrows(IllegalStateException.class, () -> pedido.cancelar());
    }

    @Test
    void noPuedePagarDosVeces() {
        pedido.pagar();
        assertThrows(IllegalStateException.class, () -> pedido.pagar());
    }

    @Test
    void noPuedeEnviarSinPagar() {
        assertThrows(IllegalStateException.class, () -> pedido.enviar());
    }

    @Test
    void noPuedeEntregarSinEnviar() {
        pedido.pagar();
        assertThrows(IllegalStateException.class, () -> pedido.entregar());
    }

    @Test
    void noPuedeCambiarEstadoDesdeEntregado() {
        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
        assertThrows(IllegalStateException.class, () -> pedido.pagar());
        assertThrows(IllegalStateException.class, () -> pedido.enviar());
        assertThrows(IllegalStateException.class, () -> pedido.cancelar());
    }

    @Test
    void noPuedeCambiarEstadoDesdeCancelado() {
        pedido.cancelar();
        assertThrows(IllegalStateException.class, () -> pedido.pagar());
        assertThrows(IllegalStateException.class, () -> pedido.enviar());
        assertThrows(IllegalStateException.class, () -> pedido.entregar());
    }

}
