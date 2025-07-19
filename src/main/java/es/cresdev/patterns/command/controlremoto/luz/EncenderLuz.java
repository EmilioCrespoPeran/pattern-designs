package es.cresdev.patterns.command.controlremoto.luz;

import es.cresdev.patterns.command.controlremoto.Comando;

public class EncenderLuz implements Comando {

    private final Luz luz;

    public EncenderLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public String ejecutar() {
        return luz.encender();
    }

    @Override
    public String deshacer() {
        return luz.apagar();
    }
}
