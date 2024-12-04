package Persistencia;

public interface IMencionesRepository {
	
	public void agregarMencion(int usuarioId, int zetaId);
	public void removerMencion(int usuarioId, int zetaId);
}
