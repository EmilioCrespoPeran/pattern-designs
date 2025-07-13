package es.cresdev.patterns.observer.productos.observadores;

import es.cresdev.patterns.observer.productos.ObservadorProducto;

public class IndicadorDeReabastecimiento extends ObservadorProducto {
    @Override
    public void notificarStock(int stockAnterior, int stockActual) {
        if (stockAnterior == 0 && stockActual > 0) {
            this.ultimaNotificacion = "✅ Producto reabastecido: " + stockAnterior + " -> " + stockActual;
        }
    }

    @Override
    public void notificarPrecio(float precioAnterior, float precioActual) {

    }
}
