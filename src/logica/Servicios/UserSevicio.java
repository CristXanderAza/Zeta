package logica.Servicios;

import java.util.List;

import Persistencia.ITemaRepository;
import Persistencia.IUserRepository;
import logica.Tema;
import logica.Usuario;

public class UserSevicio implements IUserServicio{
	
	private IUserRepository repo;
	private ITemaRepository temaRepo;
	
	
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
	@Override
	public Boolean CrearNuevoUsuario(String nombre, String correo, String username, String contrasenia, List<Tema> temas) {
		
		if(repo.getByUsername(username) != null) {
			return false;
		}
		
		Usuario u = new Usuario(nombre, correo, username, Usuario.encriptar(contrasenia));
		int usuarioID = repo.add(u);
		for (Tema tema : temas) {
			temaRepo.agregarTemaAUsuario(usuarioID, tema.getTemaID());
		}
		return true;
	}

}
