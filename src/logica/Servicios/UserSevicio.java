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
		System.out.println("Nombre Usuario, encontrado: " + u.getNombre() + u.getContrasenia());
		return (u.autenticar(contrasenia))? u: null;
	}

}
