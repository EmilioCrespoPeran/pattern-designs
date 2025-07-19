package es.cresdev.patterns.chainofresponsability.soportetecnico;

import es.cresdev.patterns.chainofresponsability.soportetecnico.nivel.SoporteNivel1;
import es.cresdev.patterns.chainofresponsability.soportetecnico.nivel.SoporteNivel2;
import es.cresdev.patterns.chainofresponsability.soportetecnico.nivel.SoporteNivel3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ChainOfResponsabilitySoporteTecnicoTests {

    private SoporteHandler construirCadenaSoporte() {
        return new SoporteNivel1(
                new SoporteNivel2(
                        new SoporteNivel3()
                )
        );
    }

    @Test
    void soporteNivel1DebeManejarSolicitudNivel1() {
        SoporteHandler soporte = construirCadenaSoporte();
        Solicitud solicitud = new Solicitud(NivelSolicitud.NIVEL_1, "Resetear contraseña");

        String resultado = soporte.manejarSolicitud(solicitud);

        assertEquals("Nivel 1 resolvió: Resetear contraseña", resultado);
    }

    @Test
    void soporteNivel2DebeManejarSolicitudNivel2() {
        SoporteHandler soporte = construirCadenaSoporte();
        Solicitud solicitud = new Solicitud(NivelSolicitud.NIVEL_2, "Error en la configuración");

        String resultado = soporte.manejarSolicitud(solicitud);

        assertEquals("Nivel 2 resolvió: Error en la configuración", resultado);
    }

    @Test
    void soporteNivel3DebeManejarSolicitudNivel3() {
        SoporteHandler soporte = construirCadenaSoporte();
        Solicitud solicitud = new Solicitud(NivelSolicitud.NIVEL_3, "Bug crítico en el sistema");

        String resultado = soporte.manejarSolicitud(solicitud);

        assertEquals("Nivel 3 resolvió: Bug crítico en el sistema", resultado);
    }

    @Test
    void solicitudNivelNoSoportadoDebeLanzarExcepcion() {
        SoporteHandler soporte = construirCadenaSoporte();
        Solicitud solicitud = new Solicitud(null, "Petición desconocida");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            soporte.manejarSolicitud(solicitud);
        });

        assertEquals("Solicitud no pudo ser procesada: Petición desconocida", exception.getMessage());
    }

    @Test
    void soporteNivel1DebeDelegarASoporteNivel2() {
        SoporteNivel2 mockNivel2 = new SoporteNivel2(null) {
            @Override
            public String manejarSolicitud(Solicitud solicitud) {
                return "Mock Nivel 2 proceso: " + solicitud.getDescripcion();
            }
        };

        SoporteNivel1 nivel1 = new SoporteNivel1(mockNivel2);
        Solicitud solicitud = new Solicitud(NivelSolicitud.NIVEL_2, "Problema intermedio");

        String resultado = nivel1.manejarSolicitud(solicitud);

        assertEquals("Mock Nivel 2 proceso: Problema intermedio", resultado);
    }

    @Test
    void soporteNivel2DebeDelegarASoporteNivel3() {
        SoporteNivel3 mockNivel3 = new SoporteNivel3(null) {
            @Override
            public String manejarSolicitud(Solicitud solicitud) {
                return "Mock Nivel 3 proceso: " + solicitud.getDescripcion();
            }
        };

        SoporteNivel2 nivel2 = new SoporteNivel2(mockNivel3);
        Solicitud solicitud = new Solicitud(NivelSolicitud.NIVEL_3, "Problema avanzado");

        String resultado = nivel2.manejarSolicitud(solicitud);

        assertEquals("Mock Nivel 3 proceso: Problema avanzado", resultado);
    }

}
