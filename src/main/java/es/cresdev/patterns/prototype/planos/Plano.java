package es.cresdev.patterns.prototype.planos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Plano implements ClonableElemento<Plano> {

    private String tipo;
    private Integer alto;
    private Integer ancho;
    private List<String> habitaciones;
    private String arquitecto;
    private ZonaComunal zonaComunal;

    @Override
    public Plano clonar() throws CloneNotSupportedException {
        if (!esValido()) {
            throw new CloneNotSupportedException("El plano tiene datos inválidos.");
        }

        return new Plano(
                tipo, // No hace falta clonar String
                alto,
                ancho,
                new ArrayList<>(habitaciones), // Deep copy de lista
                arquitecto,
                zonaComunal.clonar()
        );
    }

    @Override
    public boolean esValido() {
        return tipo != null && !tipo.isBlank()
                && alto != null && alto > 0
                && ancho != null && ancho > 0
                && habitaciones != null && !habitaciones.isEmpty() && habitaciones.stream().noneMatch(h -> h == null || h.isBlank())
                && arquitecto != null && !arquitecto.isBlank()
                && zonaComunal != null;
    }

}
