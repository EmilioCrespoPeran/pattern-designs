package es.cresdev.patterns.state.pedido;

public class PedidoEstadoPagar implements EstadoPedido {
    @Override
    public String pagar(Pedido pedido) {
        throw new IllegalStateException("El pedido ya ha sido pagado");
    }

    @Override
    public String enviar(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoEstadoEnviar());
        return "Pedido enviado";
    }

    @Override
    public String entregar(Pedido pedido) {
        throw new IllegalStateException("Debe enviarse antes de entregar");
    }

    @Override
    public String cancelar(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoEstadoCancelar());
        return "Pedido cancelado desde estado pagado";
    }

    @Override
    public String estado() {
        return "Pagado";
    }
}
