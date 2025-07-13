package es.cresdev.patterns.singleton.configuracion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
public class SingletonPatternTests {

    @Test
    void testUnicaInstancia() {
        ConfiguracionSistema config1 = ConfiguracionSistema.getInstance();
        ConfiguracionSistema config2 = ConfiguracionSistema.getInstance();

        assertSame(config1, config2); // Deben ser la misma instancia
    }

    @Test
    void testPropiedadCompartida() {
        ConfiguracionSistema config = ConfiguracionSistema.getInstance();
        config.setIdioma("ES");

        ConfiguracionSistema otra = ConfiguracionSistema.getInstance();
        assertEquals("ES", otra.getIdioma());
    }


}
