package logica.Servicios;

import java.util.List;

import logica.Zeta;

public interface IZetasServicio {
	
	public void agregarZeta(Zeta z);
	
	public Zeta getById(int id);
	
	public List<Zeta> getAll();
}
