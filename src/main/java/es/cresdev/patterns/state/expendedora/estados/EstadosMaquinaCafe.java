package es.cresdev.patterns.state.expendedora.estados;

import es.cresdev.patterns.state.expendedora.MaquinaCafe;

public interface EstadosMaquinaCafe {
    String insertarMoneda(MaquinaCafe maquinaCafe);
    String seleccionarCafe(MaquinaCafe maquinaCafe);
    String recogerCafe(MaquinaCafe maquinaCafe);
    String cancelar(MaquinaCafe maquinaCafe);
    String marcarFueraDeServicio(MaquinaCafe maquinaCafe);
    String reiniciar(MaquinaCafe maquinaCafe);
    String estado();
}
