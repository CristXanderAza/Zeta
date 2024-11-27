package Persistencia;

public interface IArchivoRepository {
	
	public int guardarImagen(String ruta);
	
	public void actualizarImagen(String ruta, int id);
	
	public void borrar(int id);
}
