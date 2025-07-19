package es.cresdev.patterns.chainofresponsability.soportetecnico;

public enum NivelSolicitud {

    NIVEL_1("Nivel 1"),
    NIVEL_2("Nivel 2"),
    NIVEL_3("Nivel 3");

    private final String nombre;

    NivelSolicitud(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
