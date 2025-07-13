package es.cresdev.patterns.facade.biblioteca;

import es.cresdev.patterns.facade.biblioteca.servicios.ServicioLibros;
import es.cresdev.patterns.facade.biblioteca.servicios.ServicioNotificaciones;
import es.cresdev.patterns.facade.biblioteca.servicios.ServicioPrestamos;
import es.cresdev.patterns.facade.biblioteca.servicios.ServicioUsuarios;

public class BibliotecaFacade {

    private final ServicioLibros servicioLibros;
    private final ServicioPrestamos servicioPrestamos;
    private final ServicioUsuarios servicioUsuarios;
    private final ServicioNotificaciones servicioNotificaciones;

    public BibliotecaFacade(
            ServicioLibros servicioLibros,
            ServicioPrestamos servicioPrestamos,
            ServicioUsuarios servicioUsuarios,
            ServicioNotificaciones servicioNotificaciones
    ) {
        this.servicioLibros = servicioLibros;
        this.servicioPrestamos = servicioPrestamos;
        this.servicioUsuarios = servicioUsuarios;
        this.servicioNotificaciones = servicioNotificaciones;
    }

    public String prestarLibro(String tituloLibro, String idUsuario) {
        if (!servicioLibros.estaDisponible(tituloLibro)) {
            return "El libro " + tituloLibro + " no está disponible";
        }
        if (!servicioUsuarios.estaActivo(idUsuario)) {
            return "El usuario " + idUsuario + " no está activo";
        }
        if (!servicioPrestamos.registrarPrestamo(tituloLibro, idUsuario)) {
            return "Error al registrar el préstamo";
        }
        if (!servicioNotificaciones.enviarNotificacion(idUsuario, "Prestamo realizado")) {
            return "Préstamo completado para el libro: " + tituloLibro + " (pero no se pudo notificar al usuario)";
        }
        return "Préstamo completado para el libro: " + tituloLibro;
    }

}
