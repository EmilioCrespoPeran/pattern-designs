package es.cresdev.patterns.state.expendedora;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MaquinaCafeTests {

    @Test
    void maquinaCafeDebeComenzarEsperandoMoneda() {
        MaquinaCafe maquina = new MaquinaCafe();
        assertEquals("EsperandoMoneda", maquina.getEstado());
    }

    @Test
    void insertarMonedaCambiaEstadoYRespondeCorrectamente() {
        MaquinaCafe maquina = new MaquinaCafe();
        String respuesta = maquina.insertarMoneda();
        assertEquals("Moneda insertada", respuesta);
        assertEquals("EsperandoSeleccion", maquina.getEstado());
    }

    @Test
    void seleccionarCafeSinMonedaLanzaExcepcion() {
        MaquinaCafe maquina = new MaquinaCafe();
        assertThrows(IllegalStateException.class, maquina::seleccionarCafe);
    }

    @Test
    void flujoCompletoFuncionamientoMaquina() {
        MaquinaCafe maquina = new MaquinaCafe();
        assertEquals("Moneda insertada", maquina.insertarMoneda());
        assertEquals("Cafe seleccionado y preparando", maquina.seleccionarCafe());
        assertEquals("Cafe listo", maquina.recogerCafe());
        assertEquals("EsperandoMoneda", maquina.getEstado());
    }

    @Test
    void cancelarSeleccionDevuelveAMoneda() {
        MaquinaCafe maquina = new MaquinaCafe();
        maquina.insertarMoneda();
        String respuesta = maquina.cancelar();
        assertEquals("Se ha cancelado la seleccion y se devuelve la moneda", respuesta);
        assertEquals("EsperandoMoneda", maquina.getEstado());
    }

    @Test
    void marcarFueraDeServicioDesdeCualquierEstado() {
        MaquinaCafe maquina = new MaquinaCafe();
        maquina.insertarMoneda();
        String respuesta = maquina.marcarFueraDeServicio();
        assertEquals("La maquina esta fuera de servicio", respuesta);
        assertEquals("FueraDeServicio", maquina.getEstado());
    }

    @Test
    void noSePuedeRecogerCafeSiNoSeSelecciono() {
        MaquinaCafe maquina = new MaquinaCafe();
        maquina.insertarMoneda();
        assertThrows(IllegalStateException.class, maquina::recogerCafe);
    }

    @Test
    void reiniciarDesdeFueraDeServicioFunciona() {
        MaquinaCafe maquina = new MaquinaCafe();
        maquina.marcarFueraDeServicio();
        assertEquals("La maquina se ha reiniciado", maquina.reiniciar());
        assertEquals("EsperandoMoneda", maquina.getEstado());
    }

    @Test
    void noSePuedeInsertarMonedaEnEstadoFueraDeServicio() {
        MaquinaCafe maquina = new MaquinaCafe();
        maquina.marcarFueraDeServicio();
        assertThrows(IllegalStateException.class, maquina::insertarMoneda);
    }

}
