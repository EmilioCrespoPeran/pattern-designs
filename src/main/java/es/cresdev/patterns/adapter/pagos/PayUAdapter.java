package es.cresdev.patterns.adapter.pagos;

public class PayUAdapter implements ProcesadorPago {

    private final PayUService payUService;

    public PayUAdapter(PayUService payUService) {
        this.payUService = payUService;
    }

    @Override
    public String procesarPago(double monto) {
        return this.payUService.realizarPago(monto);
    }
}
