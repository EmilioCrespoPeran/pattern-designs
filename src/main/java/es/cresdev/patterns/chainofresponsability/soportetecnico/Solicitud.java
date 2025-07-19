package es.cresdev.patterns.chainofresponsability.soportetecnico;

import lombok.Getter;

@Getter
public class Solicitud {

    private final NivelSolicitud nivelSolicitud;
    private final String descripcion;

    public Solicitud(NivelSolicitud nivelSolicitud, String descripcion) {
        this.nivelSolicitud = nivelSolicitud;
        this.descripcion = descripcion;
    }
}
