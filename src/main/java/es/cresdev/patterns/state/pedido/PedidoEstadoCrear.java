package es.cresdev.patterns.state.pedido;

public class PedidoEstadoCrear implements EstadoPedido {

    @Override
    public String pagar(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoEstadoPagar());
        return "Pago realizado con éxito";
    }

    @Override
    public String enviar(Pedido pedido) {
        throw new IllegalStateException("No se puede enviar un pedido sin pagar");
    }

    @Override
    public String entregar(Pedido pedido) {
        throw new IllegalStateException("No se puede entregar un pedido sin enviar");
    }

    @Override
    public String cancelar(Pedido pedido) {
        pedido.setEstadoPedido(new PedidoEstadoCancelar());
        return "Pedido cancelado desde estado creado";
    }

    @Override
    public String estado() {
        return "Creado";
    }
}

