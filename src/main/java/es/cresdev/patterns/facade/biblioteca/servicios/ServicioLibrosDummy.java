package es.cresdev.patterns.facade.biblioteca.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServicioLibrosDummy implements ServicioLibros {

    private final Set<String> disponibles = new HashSet<>(List.of("Clean Code", "Kafka en la orilla", "Fallo"));

    @Override
    public boolean estaDisponible(String titulo) {
        return disponibles.contains(titulo);
    }

}
