package es.cresdev.patterns.observer.productos.observadores;

import es.cresdev.patterns.observer.productos.ObservadorProducto;

public class NotificadorDeClientes extends ObservadorProducto {
    @Override
    public void notificarStock(int stockAnterior, int stockActual) {
        if (stockAnterior == 0 && stockActual > 0) {
            this.ultimaNotificacion = "🛒 Producto ahora disponible (stock: " + stockActual + ")";
        }
    }

    @Override
    public void notificarPrecio(float precioAnterior, float precioActual) {
        if (precioActual < precioAnterior) {
            this.ultimaNotificacion = "💰 Nuevo precio con descuento: " + precioActual;
        }
    }

}
