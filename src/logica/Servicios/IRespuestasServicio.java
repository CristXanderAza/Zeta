package logica.Servicios;

import java.util.Date;
import java.util.List;

import logica.Respuesta;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public interface IRespuestasServicio {
	
	public Respuesta agregar(ZetaInsertDTO z, Zeta publicacion);
	
	public Respuesta getById(int id);
	
	public List<Respuesta> getRespuestasDeZeta(Zeta z);
	
	public void update(Respuesta r);
	
	public void delete(Respuesta r);
	
}
