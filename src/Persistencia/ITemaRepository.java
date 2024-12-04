package Persistencia;

import java.util.List;

import logica.Tema;

public interface ITemaRepository {

	public void agregarTema(Tema tema);
	public Tema obtenerTemaPorId(int idTema);
	public List<Tema> obtenerTodosLosTemas();
    public void actualizarTema(Tema tema);
    public void eliminarTema(int idTema);
    public void agregarTemaAUsuario(int usuarioID, int temaID );
}
