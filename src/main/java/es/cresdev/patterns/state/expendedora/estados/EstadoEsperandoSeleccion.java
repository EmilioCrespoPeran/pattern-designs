package es.cresdev.patterns.state.expendedora.estados;

import es.cresdev.patterns.state.expendedora.MaquinaCafe;

public class EstadoEsperandoSeleccion implements EstadosMaquinaCafe {
    @Override
    public String insertarMoneda(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("Ya se ha insertado una moneda");
    }

    @Override
    public String seleccionarCafe(MaquinaCafe maquinaCafe) {
        maquinaCafe.setEstadosMaquinaCafe(new EstadoPreparando());
        return "Cafe seleccionado y preparando";
    }

    @Override
    public String recogerCafe(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede recoger el cafe antes de seleccionarse");
    }

    @Override
    public String cancelar(MaquinaCafe maquinaCafe) {
        maquinaCafe.setEstadosMaquinaCafe(new EstadoEsperandoMoneda());
        return "Se ha cancelado la seleccion y se devuelve la moneda";
    }

    @Override
    public String marcarFueraDeServicio(MaquinaCafe maquinaCafe) {
        maquinaCafe.setEstadosMaquinaCafe(new EstadoFueraDeServicio());
        return "La maquina esta fuera de servicio";
    }

    @Override
    public String reiniciar(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede reiniciar sin estar fuera de servicio");
    }

    @Override
    public String estado() {
        return "EsperandoSeleccion";
    }
}
