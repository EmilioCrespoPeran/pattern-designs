package es.cresdev.patterns.notifications;

import es.cresdev.patterns.factory.notificaciones.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NotificacionFactoryTests {
    /*
    @Test
    void testCrearEmailNotificacion() {
        Notificacion notificacion = NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.EMAIL);
        assertTrue(notificacion instanceof EmailNotificacion);
        assertEquals("[EMAIL] Mensaje enviado", notificacion.enviar());
    }

    @Test
    void testCrearSMSNotificacion() {
        Notificacion notificacion = NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.SMS);
        assertTrue(notificacion instanceof SMSNotificacion);
        assertEquals("[SMS] Mensaje enviado", notificacion.enviar());
    }

    @Test
    void testCrearPushNotificacion() {
        Notificacion notificacion = NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.PUSH);
        assertTrue(notificacion instanceof PushNotificacion);
        assertEquals("[PUSH] Mensaje enviado", notificacion.enviar());
    }

    @Test
    void testTipoInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            NotificacionFactory.crearNotificacion(null);
        });
    }
    */

    @Test
    void testCrearEmailNotificacionValida() {
        EmailParametrosNotificacionDTO parametros = new EmailParametrosNotificacionDTO("usuario@ejemplo.com", "Hola Email");
        Notificacion notificacion = NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.EMAIL, parametros);

        assertTrue(notificacion instanceof EmailNotificacion);
        assertEquals("[EMAIL] Mensaje enviado a usuario@ejemplo.com con contenido 'Hola Email'", notificacion.enviar());
    }

    @Test
    void testCrearSMSNotificacionValida() {
        SMSParametrosNotificacionDTO parametros = new SMSParametrosNotificacionDTO("123456789");
        Notificacion notificacion = NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.SMS, parametros);

        assertTrue(notificacion instanceof SMSNotificacion);
        assertEquals("[SMS] Mensaje enviado al número 123456789", notificacion.enviar());
    }

    @Test
    void testCrearPushNotificacionSinParametros() {
        Notificacion notificacion = NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.PUSH);

        assertNotNull(notificacion);
        assertEquals("[PUSH] Mensaje enviado", notificacion.enviar()); // Asegúrate que tu PushNotificacion implemente enviar() así
    }

    @Test
    void testCrearNotificacionTipoNullLanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            NotificacionFactory.crearNotificacion(null, null);
        });
        assertEquals("El tipo no existe: null", ex.getMessage());
    }

    @Test
    void testCrearEmailConDTOInvalidoLanzaExcepcion() {
        SMSParametrosNotificacionDTO smsDTO = new SMSParametrosNotificacionDTO("12345");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.EMAIL, smsDTO);
        });
        assertEquals("El tipo EMAIL no tiene la configuracion adecuada", ex.getMessage());
    }

    @Test
    void testCrearSMSConDTOInvalidoLanzaExcepcion() {
        EmailParametrosNotificacionDTO emailDTO = new EmailParametrosNotificacionDTO("correo@ejemplo.com", "msg");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.SMS, emailDTO);
        });
        assertEquals("El tipo SMS no tiene la configuracion adecuada", ex.getMessage());
    }

    @Test
    void testCrearEmailConParametrosNullLanzaExcepcionEnConstructor() {
        EmailParametrosNotificacionDTO parametros = new EmailParametrosNotificacionDTO(null, "mensaje");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.EMAIL, parametros);
        });
        assertEquals("[EMAIL] No existe el destinatario", ex.getMessage());
    }

    @Test
    void testCrearSMSConParametrosNullLanzaExcepcionEnConstructor() {
        SMSParametrosNotificacionDTO parametros = new SMSParametrosNotificacionDTO(null);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            NotificacionFactory.crearNotificacion(NotificacionFactory.TIPOS.SMS, parametros);
        });
        assertEquals("[SMS] No existe el número de destino", ex.getMessage());
    }
}
