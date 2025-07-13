package es.cresdev.patterns.factory.notificaciones;

public class EmailNotificacion implements Notificacion {

    private String correo;
    private String mensaje;

    public EmailNotificacion(EmailParametrosNotificacionDTO parametros) {
        if (parametros == null || parametros.getCorreo() == null || parametros.getCorreo().isBlank()) {
            throw new IllegalArgumentException("[EMAIL] No existe el destinatario");
        }
        this.correo = parametros.getCorreo();
        this.mensaje = parametros.getMensaje();
    }

    @Override
    public String enviar() {
        return String.format("[EMAIL] Mensaje enviado a %s con contenido '%s'", correo, mensaje);
    }
}
