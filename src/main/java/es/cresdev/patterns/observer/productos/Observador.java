package es.cresdev.patterns.observer.productos;

public interface Observador {
    void notificarStock(int stockAnterior, int stockActual);
    void notificarPrecio(float precioAnterior, float precioActual);
    String obtenerIdentificador();
    String getUltimaNotificacion();
}
