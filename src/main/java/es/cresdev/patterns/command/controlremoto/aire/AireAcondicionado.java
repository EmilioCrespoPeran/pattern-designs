package es.cresdev.patterns.command.controlremoto.aire;

public class AireAcondicionado {

    private boolean encendido;
    private int temperatura = 25;

    public String encender() {
        this.encendido = true;
        return "Aire acondicionado encendido";
    }

    public String apagar() {
        if (!encendido) {
            throw new IllegalStateException("El aire acondicionado no esta encendido");
        }
        this.encendido = false;
        return "Aire acondicionado apagado";
    }

    public String subirTemperatura() {
        if (!encendido) {
            throw new IllegalStateException("El aire acondicionado no esta encendido");
        }
        if (temperatura == 27) {
            throw new IllegalStateException("No se puede subir la temperatura más de 27º");
        }
        temperatura++;
        return "Temperatura aumentada a " + temperatura;
    }

    public String bajarTemperatura() {
        if (!encendido) {
            throw new IllegalStateException("El aire acondicionado no esta encendido");
        }
        if (temperatura == 18) {
            throw new IllegalStateException("No se puede bajar la temperatura menos de 18º");
        }
        temperatura--;
        return "Temperatura disminuida a " + temperatura;
    }

}
