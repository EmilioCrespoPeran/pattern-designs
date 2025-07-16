package es.cresdev.patterns.state.pedido;

public interface EstadoPedido {
    String pagar(Pedido pedido);
    String enviar(Pedido pedido);
    String entregar(Pedido pedido);
    String cancelar(Pedido pedido);
    String estado();
}
