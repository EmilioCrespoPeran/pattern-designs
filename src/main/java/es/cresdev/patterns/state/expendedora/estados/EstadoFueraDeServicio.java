package es.cresdev.patterns.state.expendedora.estados;

import es.cresdev.patterns.state.expendedora.MaquinaCafe;

public class EstadoFueraDeServicio implements EstadosMaquinaCafe {
    @Override
    public String insertarMoneda(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No admite monedas, la maquina esta fuera de servicio");
    }

    @Override
    public String seleccionarCafe(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede seleccionar un cafe, la maquina esta fuera de servicio");
    }

    @Override
    public String recogerCafe(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede recoger el cafe, la maquina esta fuera de servicio");
    }

    @Override
    public String cancelar(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede cancelar, la maquina esta fuera de servicio");
    }

    @Override
    public String marcarFueraDeServicio(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("Ya se encuentra fuera de servicio");
    }

    @Override
    public String reiniciar(MaquinaCafe maquinaCafe) {
        maquinaCafe.setEstadosMaquinaCafe(new EstadoEsperandoMoneda());
        return "La maquina se ha reiniciado";
    }

    @Override
    public String estado() {
        return "FueraDeServicio";
    }
}
