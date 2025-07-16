package es.cresdev.patterns.state.pedido;

public class PedidoEstadoCancelar implements EstadoPedido {
    @Override
    public String pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado");
    }

    @Override
    public String enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado");
    }

    @Override
    public String entregar(Pedido pedido) {
        throw new IllegalStateException("Pedido cancelado");
    }

    @Override
    public String cancelar(Pedido pedido) {
        throw new IllegalStateException("Ya está cancelado");
    }

    @Override
    public String estado() {
        return "Cancelado";
    }
}
