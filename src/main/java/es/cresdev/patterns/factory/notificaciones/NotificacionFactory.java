package es.cresdev.patterns.factory.notificaciones;

public class NotificacionFactory {

    public enum TIPOS {
        EMAIL, SMS, PUSH
    }

    public static Notificacion crearNotificacion(TIPOS tipo) {
        return crearNotificacion(tipo, null);
    }

    public static Notificacion crearNotificacion(TIPOS tipo, ParametrosNotificacionDTO parametros) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo no existe: " + tipo);
        }

        validarConfiguracion(tipo, parametros);

        Notificacion notificacion;

        switch (tipo) {
            case EMAIL -> notificacion = new EmailNotificacion((EmailParametrosNotificacionDTO) parametros);
            case SMS -> notificacion = new SMSNotificacion((SMSParametrosNotificacionDTO) parametros);
            case PUSH -> notificacion = new PushNotificacion();
            default -> throw new IllegalArgumentException("Tipo de notificación y configuracion no implementado: " + tipo);
        }

        return notificacion;
    }

    private static void validarConfiguracion(TIPOS tipo, ParametrosNotificacionDTO parametros) {
        if ((tipo == TIPOS.EMAIL && !(parametros instanceof EmailParametrosNotificacionDTO)) ||
                (tipo == TIPOS.SMS && !(parametros instanceof SMSParametrosNotificacionDTO))) {
            throw new IllegalArgumentException("El tipo " + tipo + " no tiene la configuracion adecuada");
        }
    }

}
