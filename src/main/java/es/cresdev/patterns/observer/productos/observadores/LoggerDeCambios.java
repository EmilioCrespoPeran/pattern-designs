package es.cresdev.patterns.observer.productos.observadores;

import es.cresdev.patterns.observer.productos.ObservadorProducto;

public class LoggerDeCambios extends ObservadorProducto {

    @Override
    public void notificarStock(int stockAnterior, int stockActual) {
        if (stockAnterior != stockActual) {
            this.ultimaNotificacion = "[LOG] Stock: " + stockAnterior + " -> " + stockActual;
        }
    }

    @Override
    public void notificarPrecio(float precioAnterior, float precioActual) {
        if (precioAnterior != precioActual) {
            this.ultimaNotificacion = "[LOG] Precio: " + precioAnterior + " -> " + precioActual;
        }
    }

}
