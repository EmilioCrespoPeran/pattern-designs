package es.cresdev.patterns.factory.notificaciones;

public class SMSParametrosNotificacionDTO implements ParametrosNotificacionDTO {

    private String numero;

    public SMSParametrosNotificacionDTO(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
