package es.cresdev.patterns.chainofresponsability.soportetecnico.nivel;

import es.cresdev.patterns.chainofresponsability.soportetecnico.NivelSolicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.Solicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.SoporteHandler;

public abstract class SoporteBase implements SoporteHandler {

    protected SoporteHandler siguienteNivel;
    protected final NivelSolicitud nivelSolicitudSoporte;

    public SoporteBase(SoporteHandler siguienteNivel, NivelSolicitud nivelSolicitudSoporte) {
        this.siguienteNivel = siguienteNivel;
        this.nivelSolicitudSoporte = nivelSolicitudSoporte;
    }

    @Override
    public String manejarSolicitud(Solicitud solicitud) {
        if (solicitud == null) {
            throw new IllegalArgumentException("Solicitud no pudo ser procesada: " + solicitud.getDescripcion());
        }
        if (!solicitud.getNivelSolicitud().equals(this.nivelSolicitudSoporte) && this.siguienteNivel == null) {
            throw new IllegalStateException("Solicitud no pudo ser procesada: " + solicitud.getDescripcion());
        }

        return solicitud.getNivelSolicitud().equals(this.nivelSolicitudSoporte)
                ? this.nivelSolicitudSoporte.getNombre() + " resolvió: " + solicitud.getDescripcion()
                : siguienteNivel.manejarSolicitud(solicitud);
    }

}
