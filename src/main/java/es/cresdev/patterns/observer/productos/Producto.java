package es.cresdev.patterns.observer.productos;

import java.util.ArrayList;

public class Producto implements Sujeto {

    private final String nombre;
    private float precio;
    private int stock;
    private final ArrayList<Observador> observadores;

    public Producto(String nombre, float precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.observadores = new ArrayList<>();
    }

    public void setPrecio(float precio) {
        if (this.precio != precio) {
            float precioAnterior = this.precio;
            this.precio = precio;
            this.observadores.forEach(o -> o.notificarPrecio(precioAnterior, this.precio));
        }
    }

    public void setStock(int stock) {
        if (this.stock != stock) {
            int stockAnterior = this.stock;
            this.stock = stock;
            this.observadores.forEach(o -> o.notificarStock(stockAnterior, this.stock));
        }
    }

    @Override
    public void agregar(Observador observador) {
        this.observadores.add(observador);
    }

    @Override
    public void eliminar(Observador observador) {
        this.observadores.removeIf(o -> o.obtenerIdentificador().equalsIgnoreCase(observador.obtenerIdentificador()));
    }

    public void eliminarTodos() {
        this.observadores.clear();
    }

}
