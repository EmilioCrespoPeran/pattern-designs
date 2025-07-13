package es.cresdev.patterns.facade.biblioteca.servicios;

public class ServicioPrestamosDummy implements ServicioPrestamos {
    @Override
    public boolean registrarPrestamo(String titulo, String idUsuario) {
        return !(titulo.equals("Fallo") || idUsuario.equals("fallo123"));
    }
}
