package es.cresdev.patterns.state.pedido;

public class Pedido {

    private EstadoPedido estadoPedido;

    public Pedido() {
        estadoPedido = new PedidoEstadoCrear();
    }

    public String pagar() {
        return estadoPedido.pagar(this);
    }

    public String enviar() {
        return estadoPedido.enviar(this);
    }

    public String entregar() {
        return estadoPedido.entregar(this);
    }

    public String cancelar() {
        return estadoPedido.cancelar(this);
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getEstadoActual() {
        return estadoPedido.estado();
    }

}
