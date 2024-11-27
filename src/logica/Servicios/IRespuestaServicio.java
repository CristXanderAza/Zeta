package logica.Servicios;

import java.util.List;

import logica.Respuesta;
import logica.Zeta;
import logica.ZetaInsertDTO;

public interface IRespuestaServicio {

	public List<Respuesta> obtenerRespuestasDeZeta(Zeta z);
	public void responder(ZetaInsertDTO dto, Zeta z);
}
