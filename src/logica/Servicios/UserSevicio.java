package logica.Servicios;

import Persistencia.IUserRepository;
import logica.Usuario;

public class UserSevicio implements IUserServicio{
	
	private IUserRepository repo;
	
	
	public UserSevicio(IUserRepository rep) {
		this.repo = rep;
	}
	
	@Override
	public Usuario iniciarSesion(String userName, String contrasenia) {
		// TODO Auto-generated method stub
		Usuario u = repo.getByUsername(userName);		
		return (u.autenticar(contrasenia))? u: null;
	}

}
