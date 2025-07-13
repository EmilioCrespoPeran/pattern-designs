package es.cresdev.patterns.observer.productos.observadores;

import es.cresdev.patterns.observer.productos.ObservadorProducto;

public class SeguimientoDeDescuentos extends ObservadorProducto {
    @Override
    public void notificarStock(int stockAnterior, int stockActual) {

    }

    @Override
    public void notificarPrecio(float precioAnterior, float precioActual) {
        if (precioActual < precioAnterior) {
            this.ultimaNotificacion = "Descuento aplicado: antes " + precioAnterior + " ahora " + precioActual;
        }
    }
}
