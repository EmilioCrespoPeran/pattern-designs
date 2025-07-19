package es.cresdev.patterns.command.controlremoto;

import es.cresdev.patterns.command.controlremoto.aire.*;
import es.cresdev.patterns.command.controlremoto.luz.ApagarLuz;
import es.cresdev.patterns.command.controlremoto.luz.EncenderLuz;
import es.cresdev.patterns.command.controlremoto.luz.Luz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommandControlRemotoTests {

    private ControlRemoto control;
    private Luz luzSala;
    private Luz luzCocina;
    private AireAcondicionado aire;

    @BeforeEach
    void setUp() {
        control = new ControlRemoto();
        luzSala = new Luz();
        luzCocina = new Luz();
        aire = new AireAcondicionado();
    }

    @Test
    void testEjecutarComandoEncenderLuz() {
        control.asignarComando(1, new EncenderLuz(luzSala));
        String resultado = control.presionarBoton(1);
        assertEquals("Luz encendida", resultado);
    }

    @Test
    void testEjecutarComandoApagarLuz() {
        luzSala.encender(); // Prenderla primero
        control.asignarComando(1, new ApagarLuz(luzSala));
        String resultado = control.presionarBoton(1);
        assertEquals("Luz apagada", resultado);
    }

    @Test
    void testEjecutarComandoEncenderAire() {
        control.asignarComando(2, new EncenderAireAcondicionado(aire));
        String resultado = control.presionarBoton(2);
        assertEquals("Aire acondicionado encendido", resultado);
    }

    @Test
    void testReprogramarBoton() {
        control.asignarComando(1, new EncenderLuz(luzSala));
        control.asignarComando(1, new ApagarLuz(luzSala)); // Reprogramar
        String resultado = control.presionarBoton(1);
        assertEquals("Luz apagada", resultado);
    }

    @Test
    void testEjecutarBotonSinComando() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            control.presionarBoton(99);
        });
        assertTrue(exception.getMessage().contains("No se ha programado el boton"));
    }

    @Test
    void testIndependenciaDeDispositivos() {
        control.asignarComando(1, new EncenderLuz(luzSala));
        control.asignarComando(2, new EncenderLuz(luzCocina));

        String resultadoSala = control.presionarBoton(1);
        String resultadoCocina = control.presionarBoton(2);

        assertEquals("Luz encendida", resultadoSala);
        assertEquals("Luz encendida", resultadoCocina);
        assertTrue(luzSala.estaEncendida());
        assertTrue(luzCocina.estaEncendida());
    }


    @Test
    void testCancelarComandoYBotonVacio() {
        control.asignarComando(5, new EncenderLuz(luzSala));
        control.quitarComando(5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            control.presionarBoton(5);
        });
        assertTrue(exception.getMessage().contains("No se ha programado el boton"));
    }


    @Test
    void encenderLuz_debeEncenderYDeshacerDebeApagar() {
        Luz luz = new Luz();
        Comando encender = new EncenderLuz(luz);

        String resultado = encender.ejecutar();
        assertEquals("Luz encendida", resultado);
        assertTrue(luz.estaEncendida());

        String deshacer = encender.deshacer();
        assertEquals("Luz apagada", deshacer);
        assertFalse(luz.estaEncendida());
    }

    @Test
    void controlRemotoDebeRecordarYDeshacerUltimoComandoEjecutado() {
        Luz luz = new Luz();
        ControlRemoto control = new ControlRemoto();
        Comando encender = new EncenderLuz(luz);
        control.asignarComando(1, encender);

        control.presionarBoton(1); // ejecuta
        assertTrue(luz.estaEncendida());

        String resultado = control.deshacerUltimoComando(); // nuevo método
        assertEquals("Luz apagada", resultado);
        assertFalse(luz.estaEncendida());
    }

    @Test
    void deshacerSinComandoEjecutadoDebeLanzarError() {
        ControlRemoto control = new ControlRemoto();
        assertThrows(IllegalStateException.class, control::deshacerUltimoComando);
    }


    @Test
    void encenderYDeshacerDebeApagar() {
        AireAcondicionado aire = new AireAcondicionado();
        Comando encender = new EncenderAireAcondicionado(aire);

        assertEquals("Aire acondicionado encendido", encender.ejecutar());
        assertEquals("Aire acondicionado apagado", encender.deshacer());
    }


    @Test
    void apagarSinEstarEncendidoDebeLanzarExcepcion() {
        AireAcondicionado aire = new AireAcondicionado();
        Comando apagar = new ApagarAireAcondicionado(aire);

        assertThrows(IllegalStateException.class, apagar::ejecutar);
    }

    @Test
    void subirTemperaturaYDeshacerDebeBajar() {
        AireAcondicionado aire = new AireAcondicionado();
        aire.encender();
        Comando subir = new SubirTemperaturaAireAcondicionado(aire);

        assertEquals("Temperatura aumentada a 26", subir.ejecutar());
        assertEquals("Temperatura disminuida a 25", subir.deshacer());
    }

    @Test
    void bajarTemperaturaYDeshacerDebeSubir() {
        AireAcondicionado aire = new AireAcondicionado();
        aire.encender();
        aire.bajarTemperatura(); // 24
        Comando bajar = new BajarTemperaturaAireAcondicionado(aire);

        assertEquals("Temperatura disminuida a 23", bajar.ejecutar());
        assertEquals("Temperatura aumentada a 24", bajar.deshacer());
    }

    @Test
    void noDebePermitirSubirMasDe27() {
        AireAcondicionado aire = new AireAcondicionado();
        aire.encender();
        aire.subirTemperatura(); // 26
        aire.subirTemperatura(); // 27
        Comando subir = new SubirTemperaturaAireAcondicionado(aire);

        assertThrows(IllegalStateException.class, subir::ejecutar);
    }

    @Test
    void noDebePermitirBajarMenosDe18() {
        AireAcondicionado aire = new AireAcondicionado();
        aire.encender();
        for (int i = 0; i < 7; i++) {
            aire.bajarTemperatura(); // llega a 18
        }
        Comando bajar = new BajarTemperaturaAireAcondicionado(aire);

        assertThrows(IllegalStateException.class, bajar::ejecutar);
    }

    @Test
    void controlRemotoDebeEjecutarYDeshacerUltimoComando() {
        AireAcondicionado aire = new AireAcondicionado();
        aire.encender();
        ControlRemoto control = new ControlRemoto();

        Comando subir = new SubirTemperaturaAireAcondicionado(aire);
        control.asignarComando(1, subir);

        assertEquals("Temperatura aumentada a 26", control.presionarBoton(1));
        assertEquals("Temperatura disminuida a 25", control.deshacerUltimoComando());
    }


    @Test
    void debeDeshacerComandosEnOrdenInversoIndependientementeDelDispositivo() {
        // Dispositivos
        AireAcondicionado aire = new AireAcondicionado();
        aire.encender(); // Encendido manual para pruebas de temperatura

        Luz luz = new Luz();

        // Comandos
        Comando encenderLuz = new EncenderLuz(luz);                     // Botón 1
        Comando subirTemperatura = new SubirTemperaturaAireAcondicionado(aire); // Botón 2
        Comando bajarTemperatura = new BajarTemperaturaAireAcondicionado(aire); // Botón 3
        Comando apagarLuz = new ApagarLuz(luz);                         // Botón 4

        // Control remoto
        ControlRemoto control = new ControlRemoto();
        control.asignarComando(1, encenderLuz);
        control.asignarComando(2, subirTemperatura);
        control.asignarComando(3, bajarTemperatura);
        control.asignarComando(4, apagarLuz);

        // Ejecución
        assertEquals("Luz encendida", control.presionarBoton(1)); // luz ON
        assertEquals("Temperatura aumentada a 26", control.presionarBoton(2)); // aire 26
        assertEquals("Temperatura disminuida a 25", control.presionarBoton(3)); // aire 25
        assertEquals("Luz apagada", control.presionarBoton(4)); // luz OFF

        // Deshacer último comando → luz vuelve a encenderse
        assertEquals("Luz encendida", control.deshacerUltimoComando());

        // Deshacer bajar temperatura → vuelve a 26
        assertEquals("Temperatura aumentada a 26", control.deshacerUltimoComando());

        // Deshacer subir temperatura → vuelve a 25
        assertEquals("Temperatura disminuida a 25", control.deshacerUltimoComando());

        // Deshacer encender luz → luz apagada
        assertEquals("Luz apagada", control.deshacerUltimoComando());

        // Validación final
        assertFalse(luz.estaEncendida());
        // Temperatura debe estar en 25, no accesible directamente, pero puedes reflejarlo añadiendo un método getter si es necesario
    }


}
