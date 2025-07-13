package es.cresdev.patterns.prototype.planos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ZonaComunal implements ClonableElemento<ZonaComunal> {

    private String nombre;
    private Integer metros;
    private Boolean accesibilidad;

    @Override
    public ZonaComunal clonar() throws CloneNotSupportedException {
        if (!esValido()) {
            throw new CloneNotSupportedException("Los datos no son validos");
        }
        return new ZonaComunal(
                nombre,
                metros,
                accesibilidad
        );
    }

    @Override
    public boolean esValido() {
        return nombre != null && !nombre.isBlank()
                && metros != null && metros > 0
                && accesibilidad != null;
    }
}
