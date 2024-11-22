package logica.Servicios;

import java.util.Date;
import java.util.List;

import logica.Rezeta;
import logica.Usuario;
import logica.Zeta;

public interface IRezetaServicio {

	public Rezeta add(Usuario u, Zeta z);
	
	public List<Rezeta> getRezetaDeZeta(Zeta z);

	public List<Rezeta> getRezetaDeUsuarioInTiemLapse(Usuario u, Date inicio, Date finall);
	
	public List<Rezeta> getRezetaPorSeguiendo(Usuario u);
	
	public void delete(Rezeta rz);


}
