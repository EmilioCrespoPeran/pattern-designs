package es.cresdev.patterns.chainofresponsability.soportetecnico.nivel;

import es.cresdev.patterns.chainofresponsability.soportetecnico.NivelSolicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.Solicitud;
import es.cresdev.patterns.chainofresponsability.soportetecnico.SoporteHandler;
import lombok.Setter;

@Setter
public class SoporteNivel3 extends SoporteBase {

    public SoporteNivel3() {
        super(null, NivelSolicitud.NIVEL_3);
    }

    public SoporteNivel3(SoporteHandler siguienteNivel) {
        super(siguienteNivel, NivelSolicitud.NIVEL_3);
    }

}