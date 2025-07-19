package es.cresdev.patterns.command.controlremoto.aire;

import es.cresdev.patterns.command.controlremoto.Comando;

public class EncenderAireAcondicionado implements Comando {

    private final AireAcondicionado aireAcondicionado;

    public EncenderAireAcondicionado(AireAcondicionado aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String ejecutar() {
        return aireAcondicionado.encender();
    }

    @Override
    public String deshacer() {
        return aireAcondicionado.apagar();
    }
}
