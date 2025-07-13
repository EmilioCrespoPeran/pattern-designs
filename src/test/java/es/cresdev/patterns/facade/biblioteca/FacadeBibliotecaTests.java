package es.cresdev.patterns.facade.biblioteca;

import es.cresdev.patterns.facade.biblioteca.servicios.ServicioLibrosDummy;
import es.cresdev.patterns.facade.biblioteca.servicios.ServicioNotificacionesDummy;
import es.cresdev.patterns.facade.biblioteca.servicios.ServicioPrestamosDummy;
import es.cresdev.patterns.facade.biblioteca.servicios.ServicioUsuariosDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FacadeBibliotecaTests {

    private BibliotecaFacade facade;

    @BeforeEach
    void setUp() {
        facade = new BibliotecaFacade(
                new ServicioLibrosDummy(),
                new ServicioPrestamosDummy(),
                new ServicioUsuariosDummy(),
                new ServicioNotificacionesDummy()
        );
    }

    @Test
    void deberiaPrestarLibroCuandoTodoEsCorrecto() {
        String resultado = facade.prestarLibro("Clean Code", "user001");
        assertEquals("Préstamo completado para el libro: Clean Code", resultado);
    }

    @Test
    void noDeberiaPrestarLibroCuandoNoEstaDisponible() {
        String resultado = facade.prestarLibro("LibroInexistente", "user002");
        assertEquals("El libro LibroInexistente no está disponible", resultado);
    }

    @Test
    void noDeberiaPrestarLibroSiUsuarioNoEstaActivo() {
        String resultado = facade.prestarLibro("Clean Code", "inactivo123");
        assertEquals("El usuario inactivo123 no está activo", resultado);
    }

    @Test
    void noDeberiaPrestarLibroSiFallaRegistroPrestamo() {
        String resultado = facade.prestarLibro("Fallo", "user004");
        assertEquals("Error al registrar el préstamo", resultado);
    }

    @Test
    void deberiaPrestarLibroPeroFallaNotificacion() {
        String resultado = facade.prestarLibro("Kafka en la orilla", "noNotificar");
        assertEquals("Préstamo completado para el libro: Kafka en la orilla (pero no se pudo notificar al usuario)", resultado);
    }

}
