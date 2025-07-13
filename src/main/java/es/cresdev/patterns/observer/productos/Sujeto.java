package es.cresdev.patterns.observer.productos;

public interface Sujeto {
    void agregar(Observador observador);
    void eliminar(Observador observador);
}
