package es.cresdev.patterns.facade.biblioteca.servicios;

import java.util.Set;

public class ServicioNotificacionesDummy implements ServicioNotificaciones {
    private final Set<String> fallos = Set.of("noNotificar");

    @Override
    public boolean enviarNotificacion(String usuarioId, String mensaje) {
        return !fallos.contains(usuarioId);
    }
}
