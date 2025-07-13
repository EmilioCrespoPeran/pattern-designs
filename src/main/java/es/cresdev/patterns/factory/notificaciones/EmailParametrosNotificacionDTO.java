package es.cresdev.patterns.factory.notificaciones;

public class EmailParametrosNotificacionDTO implements ParametrosNotificacionDTO {

    private String correo;
    private String mensaje;

    public EmailParametrosNotificacionDTO(String correo, String mensaje) {
        this.correo = correo;
        this.mensaje = mensaje;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
