package es.cresdev.patterns.factory.notificaciones;

public class PushNotificacion implements Notificacion {
    @Override
    public String enviar() {
        return "[PUSH] Mensaje enviado";
    }
}
