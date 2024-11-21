package Persistencia;

import java.util.List;

import logica.Usuario;
import logica.Zeta;

public interface IZetasRepository {
	
	public void agregarZeta(Zeta z);
	
	public Zeta getById(int id);
	
	public List<Zeta> getAll();
	
	public void Update(Zeta z);
	
	public void remove(Zeta z);
	
}
