package Persistencia;

import java.util.List;

import logica.Usuario;

public interface ILikeRepository {
	
	public void AddLike(int idCuenta, int idElemento);
	
	public void DeleteLike(int idCuenta, int idElemento);
	
	public List<Usuario> SearchUsers(int idElemento);
}
