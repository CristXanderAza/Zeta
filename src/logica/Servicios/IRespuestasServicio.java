package logica.Servicios;

import java.util.Date;
import java.util.List;

import logica.Respuesta;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public interface IRespuestasServicio {
	

	public Respuesta responder(ZetaInsertDTO dto, Usuario u, Zeta z);
	
	public void darLike(Respuesta r, Usuario actual);
	
	public void quitarLike(Respuesta r, Usuario actual);
	
	public Respuesta getById(int id);
	
	public List<Respuesta> getRespuestasDeZeta(Zeta z);
	
	public void update(Respuesta r, String newBody);
	
	public void delete(Respuesta r);
	
}
