package es.cresdev.patterns.command.controlremoto.aire;

import es.cresdev.patterns.command.controlremoto.Comando;

public class SubirTemperaturaAireAcondicionado implements Comando {

    private final AireAcondicionado aireAcondicionado;

    public SubirTemperaturaAireAcondicionado(AireAcondicionado aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String ejecutar() {
        return aireAcondicionado.subirTemperatura();
    }

    @Override
    public String deshacer() {
        return aireAcondicionado.bajarTemperatura();
    }
}
