package es.cresdev.patterns.state.pedido;

public class PedidoEstadoEntregar implements EstadoPedido {
    @Override
    public String pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido ya entregado");
    }

    @Override
    public String enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido ya entregado");
    }

    @Override
    public String entregar(Pedido pedido) {
        throw new IllegalStateException("Ya ha sido entregado");
    }

    @Override
    public String cancelar(Pedido pedido) {
        throw new IllegalStateException("No se puede cancelar un pedido entregado");
    }

    @Override
    public String estado() {
        return "Entregado";
    }
}
