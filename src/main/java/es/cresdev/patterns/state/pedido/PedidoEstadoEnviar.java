package es.cresdev.patterns.state.pedido;

public class PedidoEstadoEnviar implements EstadoPedido {

    @Override
    public String pagar(Pedido pedido) {
        throw new IllegalStateException("Ya ha sido pagado");
    }

    @Override
    public String enviar(Pedido pedido) {
        throw new IllegalStateException("Ya ha sido enviado");
    }

    @Override
    public String entregar(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoEstadoEntregar());
        return "Pedido entregado";
    }

    @Override
    public String cancelar(Pedido pedido) {
        throw new IllegalStateException("No se puede cancelar un pedido ya enviado");
    }

    @Override
    public String estado() {
        return "Enviado";
    }
}
