package Persistencia;

import java.util.List;

import logica.LikeInteraccion;
import logica.Tema;
import logica.Usuario;
import logica.Zeta;

public interface IZetasRepository {
	
	public void agregarZeta(Zeta z);
	
	public void agregarZetaConImagen(Zeta z, int archivoID);
	
	public Zeta getById(int id);
	
	public List<Zeta> getAll();
	
	public void Update(Zeta z);
	
	public void remove(Zeta z);
	
	public List<Zeta> obtenerPorHastag();
	
	public List<Zeta> obtenerPorTema(Tema t);
	
	public List<Zeta> obtenerPorUsuario(Usuario u);
	
	public int agregarImagen(String rutaArchivo);
	
	public void darLike(LikeInteraccion li);
	
	public void quitarLike(Usuario u, Zeta z);
	
}
