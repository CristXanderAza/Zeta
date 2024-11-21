package Persistencia;

import java.util.List;

import logica.Usuario;

public interface IUserRepository {

	public void add(Usuario u);
	
	public Usuario getByUsername(String username);
	
	public List<Usuario> getAll();
	
	public void Update(Usuario u);
	
	public void remove(Usuario u);
}
