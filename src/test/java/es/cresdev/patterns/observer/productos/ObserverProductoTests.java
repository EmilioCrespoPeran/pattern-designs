package es.cresdev.patterns.observer.productos;

import es.cresdev.patterns.observer.productos.observadores.AlertaStockCritico;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ObserverProductoTests {

    @Test
    void observadoresRecibenNotificacionAlCambiarPrecio() {
        Producto producto = new Producto("Laptop", 1000, 10);

        TestObserver observador1 = new TestObserver();
        TestObserver observador2 = new TestObserver();

        producto.agregar(observador1);
        producto.agregar(observador2);

        producto.setPrecio(1200);

        assertEquals("precio actualizado a 1200.0", observador1.getUltimaNotificacion());
        assertEquals("precio actualizado a 1200.0", observador2.getUltimaNotificacion());
    }

    @Test
    void observadoresRecibenNotificacionAlCambiarStock() {
        Producto producto = new Producto("Laptop", 1000, 10);

        TestObserver observador = new TestObserver();
        producto.agregar(observador);

        producto.setStock(5);

        assertEquals("stock actualizado a 5", observador.getUltimaNotificacion());
    }

    @Test
    void observadorEliminadoNoRecibeNotificaciones() {
        Producto producto = new Producto("Laptop", 1000, 10);

        TestObserver observador = new TestObserver();
        producto.agregar(observador);
        producto.eliminar(observador);

        producto.setStock(7);

        assertNull(observador.getUltimaNotificacion());
    }

    @Test
    void puedeAgregarYEliminarObservadoresDinamicamente() {
        Producto producto = new Producto("Laptop", 1000, 10);

        TestObserver observador1 = new TestObserver();
        TestObserver observador2 = new TestObserver();

        producto.agregar(observador1);
        producto.setPrecio(1100);
        assertEquals("precio actualizado a 1100.0", observador1.getUltimaNotificacion());

        producto.agregar(observador2);
        producto.setStock(15);
        assertEquals("stock actualizado a 15", observador1.getUltimaNotificacion());
        assertEquals("stock actualizado a 15", observador2.getUltimaNotificacion());

        producto.eliminar(observador1);
        producto.setPrecio(1300);

        // observador1 NO recibe nuevas notificaciones, mantiene la última recibida
        assertEquals("stock actualizado a 15", observador1.getUltimaNotificacion());
        assertEquals("precio actualizado a 1300.0", observador2.getUltimaNotificacion());
    }

    @Test
    void noSeNotificaSiPrecioNoCambia() {
        Producto producto = new Producto("Teclado", 70, 15);
        TestObserver observador = new TestObserver();
        producto.agregar(observador);

        producto.setPrecio(70); // No cambia
        assertNull(observador.getUltimaNotificacion());
    }

    @Test
    void noDuplicaNotificacionesSiSeAgregaDosVeces() {
        Producto producto = new Producto("Monitor", 300, 5);
        TestObserver observador = new TestObserver();

        producto.agregar(observador);
        producto.agregar(observador); // Segunda vez

        producto.setStock(4);
        assertEquals("stock actualizado a 4", observador.getUltimaNotificacion());
    }

    @Test
    void puedeLimpiarTodosLosObservadores() {
        Producto producto = new Producto("Tablet", 200, 8);

        TestObserver obs1 = new TestObserver();
        TestObserver obs2 = new TestObserver();

        producto.agregar(obs1);
        producto.agregar(obs2);
        producto.eliminarTodos();

        producto.setPrecio(210);

        assertNull(obs1.getUltimaNotificacion());
        assertNull(obs2.getUltimaNotificacion());
    }


    // Clase auxiliar para test, implementando Observador
    static class TestObserver extends ObservadorProducto {

        public TestObserver() {
            this(UUID.randomUUID().toString());
        }

        public TestObserver(String identificadorObservador) {
            super(identificadorObservador);
        }

        @Override
        public void notificarStock(int stockAnterior, int stockActual) {
            this.ultimaNotificacion = "stock actualizado a " + stockActual;
        }

        @Override
        public void notificarPrecio(float precioAnterior, float precioActual) {
            this.ultimaNotificacion = "precio actualizado a " + precioActual;
        }

    }

}
