package logica.Servicios;

import java.util.Date;
import java.util.List;

import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public interface IZetasServicio {
	
	public Zeta agregarZeta(ZetaInsertDTO z);
	
	public Zeta rezetear(Zeta padre,ZetaInsertDTO dto);
	
	public Zeta getById(int id);
	
	public List<Zeta> getByUserInTimeLapse(Usuario u, Date inicio, Date finall);
	
	public List<Zeta> getZetaDeSeguidos(Usuario u);
	
	public void update(Zeta z);
	
	public void delete(Zeta z);
	
	public List<Zeta> getAll();
}
