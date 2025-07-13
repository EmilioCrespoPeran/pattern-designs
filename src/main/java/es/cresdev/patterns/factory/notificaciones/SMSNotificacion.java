package es.cresdev.patterns.factory.notificaciones;

public class SMSNotificacion implements Notificacion {

    private String numero;

    public SMSNotificacion(SMSParametrosNotificacionDTO parametros) {
        if (parametros == null || parametros.getNumero() == null || parametros.getNumero().isBlank()) {
            throw new IllegalArgumentException("[SMS] No existe el número de destino");
        }
        this.numero = parametros.getNumero();
    }

    @Override
    public String enviar() {
        return "[SMS] Mensaje enviado al número " + this.numero;
    }
}
