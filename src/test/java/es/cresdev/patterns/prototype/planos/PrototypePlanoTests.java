package es.cresdev.patterns.prototype.planos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrototypePlanoTests {

    @Test
    void alClonar_unPlanoDebeMantenerTodosLosValoresIncluyendoZona() throws CloneNotSupportedException {
        ZonaComunal zona = new ZonaComunal("Parque Central", 200, true);
        Plano original = new Plano("Departamento", 80, 100, List.of("Sala", "Cocina", "Baño"), "Arq. Gómez", zona);

        Plano copia = original.clonar();

        assertEquals(original.getTipo(), copia.getTipo());
        assertEquals(original.getAlto(), copia.getAlto());
        assertEquals(original.getAncho(), copia.getAncho());
        assertEquals(original.getHabitaciones(), copia.getHabitaciones());
        assertEquals(original.getArquitecto(), copia.getArquitecto());
        assertEquals(original.getZonaComunal().getNombre(), copia.getZonaComunal().getNombre());
        assertNotSame(original, copia);
        assertNotSame(original.getZonaComunal(), copia.getZonaComunal());
    }

    @Test
    void alModificarLaCopia_noDebeAfectarAlOriginal() throws CloneNotSupportedException {
        ZonaComunal zona = new ZonaComunal("Azotea", 80, false);
        Plano original = new Plano("Casa", 100, 120, List.of("Sala", "Habitación"), "Arq. Perez", zona);

        Plano copia = original.clonar();
        copia.getHabitaciones().add("Garaje");
        copia.getZonaComunal().setNombre("Nueva Zona");

        assertNotEquals(original.getHabitaciones().size(), copia.getHabitaciones().size());
        assertNotEquals(original.getZonaComunal().getNombre(), copia.getZonaComunal().getNombre());
    }

    @Test
    void alClonar_conZonaInvalidaDebeLanzarExcepcion() {
        ZonaComunal zona = new ZonaComunal("", -10, false); // inválida
        Plano plano = new Plano("Oficina", 60, 70, List.of("Cubículo", "Recepción"), "Arq. Vega", zona);

        assertThrows(CloneNotSupportedException.class, plano::clonar);
    }

    @Test
    void alClonar_sinZonaComunalDebeLanzarExcepcion() {
        Plano plano = new Plano("Loft", 50, 50, List.of("Área única"), "Arq. Silva", null);
        assertThrows(CloneNotSupportedException.class, plano::clonar);
    }

}
