package es.cresdev.patterns.state.expendedora.estados;

import es.cresdev.patterns.state.expendedora.MaquinaCafe;

public class EstadoEsperandoMoneda implements EstadosMaquinaCafe {
    @Override
    public String insertarMoneda(MaquinaCafe maquinaCafe) {
        maquinaCafe.setEstadosMaquinaCafe(new EstadoEsperandoSeleccion());
        return "Moneda insertada";
    }

    @Override
    public String seleccionarCafe(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede seleccionar un cafe sin insertar monedas");
    }

    @Override
    public String recogerCafe(MaquinaCafe maquinaCafe) {
        throw new IllegalStateException("No se puede recoger un cafe sin insertar monedas");
    }

    @Override
    public String cancelar(MaquinaCafe maquinaCafe) {
        return "Se ha devuelvo la moneda";
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
        return "EsperandoMoneda";
    }
}
