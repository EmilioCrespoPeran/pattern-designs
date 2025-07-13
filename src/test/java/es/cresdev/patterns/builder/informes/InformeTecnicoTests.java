package es.cresdev.patterns.builder.informes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InformeTecnicoTests {

    @Test
    void testInformeCompleto() {
        InformeTecnico informe = new InformeTecnico.Builder("Título del Informe", "Contenido del informe")
                .autor("Ingeniero A")
                .fecha("2025-07-07")
                .resumen("Este informe presenta...")
                .anexos(List.of("Anexo A", "Anexo B"))
                .firma("Firmado digitalmente por A")
                .build();

        assertEquals("Título del Informe", informe.getTitulo());
        assertEquals("Contenido del informe", informe.getContenido());
        assertEquals("Ingeniero A", informe.getAutor());
        assertEquals("2025-07-07", informe.getFecha());
        assertEquals("Este informe presenta...", informe.getResumen());
        assertEquals(2, informe.getAnexos().size());
        assertEquals("Firmado digitalmente por A", informe.getFirma());
    }

    @Test
    void testInformeMinimo() {
        InformeTecnico informe = new InformeTecnico.Builder("Informe Simple", "Solo el contenido").build();

        assertEquals("Informe Simple", informe.getTitulo());
        assertEquals("Solo el contenido", informe.getContenido());
        assertNull(informe.getAutor());
        assertTrue(informe.getAnexos().isEmpty());
    }

    @Test
    void testInformeSinTituloLanzaError() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            new InformeTecnico.Builder(null, "Contenido").build();
        });
        assertEquals("El título es obligatorio", ex.getMessage());
    }

    @Test
    void testInformeSinContenidoLanzaError() {
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            new InformeTecnico.Builder("Título", null).build();
        });
        assertEquals("El contenido es obligatorio", ex.getMessage());
    }

}
