package es.cresdev.patterns.adapter.pagos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PayUAdapterTests {

    @Test
    void debeProcesarPagoUsandoPayU() {
        ProcesadorPago procesador = new PayUAdapter(new PayUService());
        String resultado = procesador.procesarPago(250.00);

        assertNotNull(resultado);
        assertTrue(resultado.contains("PayU"));
        assertEquals("Pago realizado en PayU por $250.0", resultado);
    }

    @Test
    void debeProcesarPagoUsandoStripe() {
        ProcesadorPago procesador = new StripeAdapter(new StripeService());
        String resultado = procesador.procesarPago(150.00);

        assertNotNull(resultado);
        assertEquals("Pago procesado exitosamente en Stripe: $150.0", resultado);
    }

    @Test
    void debePermitirUsoPolimorficoDelAdapter() {
        ProcesadorPago payU = new PayUAdapter(new PayUService());
        ProcesadorPago stripe = new StripeAdapter(new StripeService());

        assertEquals("Pago realizado en PayU por $100.0", payU.procesarPago(100.00));
        assertEquals("Pago procesado exitosamente en Stripe: $100.0", stripe.procesarPago(100.00));
    }

    @Test
    void debeRetornarMensajeErrorSiStripeFalla() {
        ProcesadorPago procesador = new StripeAdapter(new StripeService() {
            @Override
            public boolean charge(double amountUSD) {
                return false; // simula fallo
            }
        });

        String resultado = procesador.procesarPago(75.00);
        assertEquals("Error al procesar pago con Stripe", resultado);
    }


}
