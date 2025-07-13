package es.cresdev.patterns.observer.productos.observadores;

import es.cresdev.patterns.observer.productos.ObservadorProducto;

public class AlertaStockCritico extends ObservadorProducto {

    @Override
    public void notificarStock(int stockAnterior, int stockActual) {
        if (stockActual < 5) {
            this.ultimaNotificacion = "⚠️ Alerta: stock crítico (" + stockActual + " unidades)";
        }
    }

    @Override
    public void notificarPrecio(float precioAnterior, float precioActual) {

    }
}
