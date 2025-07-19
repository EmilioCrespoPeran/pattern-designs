package es.cresdev.patterns.command.controlremoto.aire;

import es.cresdev.patterns.command.controlremoto.Comando;

public class ApagarAireAcondicionado implements Comando {

    private final AireAcondicionado aireAcondicionado;

    public ApagarAireAcondicionado(AireAcondicionado aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String ejecutar() {
        return aireAcondicionado.apagar();
    }

    @Override
    public String deshacer() {
        return aireAcondicionado.apagar();
    }
}
