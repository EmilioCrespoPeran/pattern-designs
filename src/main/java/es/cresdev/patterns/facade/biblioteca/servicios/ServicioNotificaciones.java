package es.cresdev.patterns.facade.biblioteca.servicios;

public interface ServicioNotificaciones {
    boolean enviarNotificacion(String usuarioId, String mensaje);
}
