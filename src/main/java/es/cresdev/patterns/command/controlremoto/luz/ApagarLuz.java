package es.cresdev.patterns.command.controlremoto.luz;

import es.cresdev.patterns.command.controlremoto.Comando;

public class ApagarLuz implements Comando {

    private final Luz luz;

    public ApagarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public String ejecutar() {
        return luz.apagar();
    }

    @Override
    public String deshacer() {
        return this.luz.encender();
    }
}
