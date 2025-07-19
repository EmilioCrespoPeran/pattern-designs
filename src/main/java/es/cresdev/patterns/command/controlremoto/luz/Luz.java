package es.cresdev.patterns.command.controlremoto.luz;

public class Luz {

    private boolean encendido = false;

    public String encender() {
        this.encendido = true;
        return "Luz encendida";
    }

    public String apagar() {
        this.encendido = false;
        return "Luz apagada";
    }

    public boolean estaEncendida() {
        return this.encendido;
    }
}
