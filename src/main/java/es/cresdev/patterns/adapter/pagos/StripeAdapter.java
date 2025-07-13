package es.cresdev.patterns.adapter.pagos;

public class StripeAdapter implements ProcesadorPago {

    private final StripeService stripeService;

    public StripeAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public String procesarPago(double monto) {
        return (this.stripeService.charge(monto))
                ? "Pago procesado exitosamente en Stripe: $" + monto
                : "Error al procesar pago con Stripe" ;
    }
}
