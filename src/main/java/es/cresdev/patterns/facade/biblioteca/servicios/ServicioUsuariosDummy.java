package es.cresdev.patterns.facade.biblioteca.servicios;

public class ServicioUsuariosDummy implements ServicioUsuarios {
    @Override
    public boolean estaActivo(String idUsuario) {
        return !idUsuario.equals("inactivo123");
    }
}
