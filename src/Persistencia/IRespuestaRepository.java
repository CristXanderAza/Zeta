package Persistencia;

import java.util.List;

import logica.LikeInteraccion;
import logica.Respuesta;
import logica.Usuario;
import logica.Zeta;

public interface IRespuestaRepository {
	
	public void agregarRespuesta(Respuesta r);
	
	public List<Respuesta> obtenerRespuestasDeZeta(Zeta z);
	
	public Respuesta obtenerRespuestaPorId(int respId);
	
	public void actualizarRespuesta(Respuesta r);
	
	public void borrarRespuesta(int respuestaId);
	
	public void darLike(LikeInteraccion li);
	
	public void quitarLike(Usuario u, Respuesta r);
}
