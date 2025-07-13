package es.cresdev.patterns.adapter.pagos;

public class PayUService {
    public String realizarPago(double cantidadEnPesos) {
        return "Pago realizado en PayU por $" + cantidadEnPesos;
    }
}
