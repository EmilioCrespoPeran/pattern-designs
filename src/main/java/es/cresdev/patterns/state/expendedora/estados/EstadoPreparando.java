package es.cresdev.patterns.state.expendedora.estados;

import es.cresdev.patterns.state.expendedora.MaquinaCafe;

public class EstadoPreparando implements EstadosMaquinaCafe {
    @Override
    public String insertarMoneda(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No admite monedas mientras se prepara el pedido");
    }

    @Override
    public String seleccionarCafe(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("El cafe ya ha sido seleccionado");
    }

    @Override
    public String recogerCafe(MaquinaCafe maquinaCafe) {
        maquinaCafe.setEstadosMaquinaCafe(new EstadoEsperandoMoneda());
        return "Cafe listo";
    }

    @Override
    public String cancelar(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede cancelar el pedido en preparacion");
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
        return "preparando";
    }
}
