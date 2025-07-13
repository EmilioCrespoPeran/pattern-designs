package es.cresdev.patterns.adapter.pagos;

public class StripeService {
    public boolean charge(double amountUSD) {
        System.out.println("Stripe procesó el pago de $" + amountUSD);
        return true;
    }
}
