package es.cresdev.patterns.command.controlremoto.aire;

import es.cresdev.patterns.command.controlremoto.Comando;

public class BajarTemperaturaAireAcondicionado implements Comando {

    private final AireAcondicionado aireAcondicionado;

    public BajarTemperaturaAireAcondicionado(AireAcondicionado aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String ejecutar() {
        return aireAcondicionado.bajarTemperatura();
    }

    @Override
    public String deshacer() {
        return aireAcondicionado.subirTemperatura();
    }
}
