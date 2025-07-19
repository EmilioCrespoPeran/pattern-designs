package es.cresdev.patterns.chainofresponsability.soportetecnico.nivel;

import es.cresdev.patterns.chainofresponsability.soportetecnico.NivelSolicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.Solicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.SoporteHandler;
import lombok.Setter;

@Setter
public class SoporteNivel1 extends SoporteBase {

    public SoporteNivel1() {
        super(null, NivelSolicitud.NIVEL_1);
    }

    public SoporteNivel1(SoporteHandler siguienteNivel) {
        super(siguienteNivel, NivelSolicitud.NIVEL_1);
    }

}
