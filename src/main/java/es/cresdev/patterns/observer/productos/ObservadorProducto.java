package es.cresdev.patterns.observer.productos;

import java.util.UUID;

public abstract class ObservadorProducto implements Observador {

    protected String ultimaNotificacion;
    protected String identificadorObservador;

    public ObservadorProducto() {
        this(UUID.randomUUID().toString());
    }

    public ObservadorProducto(String identificadorObservador) {
        this.identificadorObservador = identificadorObservador;
    }

    @Override
    public String obtenerIdentificador() {
        return this.identificadorObservador;
    }

    @Override
    public String getUltimaNotificacion() {
        return this.ultimaNotificacion;
    }
}
