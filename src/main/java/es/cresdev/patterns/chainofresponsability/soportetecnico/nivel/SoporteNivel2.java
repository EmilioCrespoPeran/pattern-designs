package es.cresdev.patterns.chainofresponsability.soportetecnico.nivel;

import es.cresdev.patterns.chainofresponsability.soportetecnico.NivelSolicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.Solicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.SoporteHandler;
import lombok.Setter;

@Setter
public class SoporteNivel2 extends SoporteBase {

    public SoporteNivel2() {
        super(null, NivelSolicitud.NIVEL_2);
    }

    public SoporteNivel2(SoporteHandler siguienteNivel) {
        super(siguienteNivel, NivelSolicitud.NIVEL_2);
    }

}
