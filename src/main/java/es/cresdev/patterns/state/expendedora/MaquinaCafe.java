package es.cresdev.patterns.state.expendedora;

import es.cresdev.patterns.state.expendedora.estados.EstadosMaquinaCafe;
import es.cresdev.patterns.state.expendedora.estados.EstadoEsperandoMoneda;

public class MaquinaCafe {

    private EstadosMaquinaCafe estadosMaquinaCafe;

    public MaquinaCafe() {
        this.estadosMaquinaCafe = new EstadoEsperandoMoneda();
    }

    public String insertarMoneda() {
        return estadosMaquinaCafe.insertarMoneda(this);
    }

    public String seleccionarCafe() {
        return estadosMaquinaCafe.seleccionarCafe(this);
    }

    public String recogerCafe() {
        return estadosMaquinaCafe.recogerCafe(this);
    }

    public String cancelar() {
        return estadosMaquinaCafe.cancelar(this);
    }

    public String marcarFueraDeServicio() {
        return estadosMaquinaCafe.marcarFueraDeServicio(this);
    }

    public String reiniciar() {
        return estadosMaquinaCafe.reiniciar(this);
    }

    public void setEstadosMaquinaCafe(EstadosMaquinaCafe estadosMaquinaCafe) {
        this.estadosMaquinaCafe = estadosMaquinaCafe;
    }

    public String getEstado() {
        return estadosMaquinaCafe.estado();
    }

}
