package logica.Servicios;

import java.util.List;

import Persistencia.ITemaRepository;
import Persistencia.IUserRepository;
import logica.Tema;
import logica.Usuario;

public class UserSevicio implements IUserServicio{
	
	private IUserRepository repo;
	private ITemaRepository temaRepo;
	
	
	public UserSevicio(IUserRepository rep, ITemaRepository temaRepo) {
		this.repo = rep;
		this.temaRepo = temaRepo;
	}
	
	@Override
	public Usuario iniciarSesion(String userName, String contrasenia) {
		// TODO Auto-generated method stub
		Usuario u = repo.getByUsername(userName);		
		if(u != null) {
			System.out.println("Nombre Usuario, encontrado: " + u.getNombre() + u.getContrasenia());
			return (u.autenticar(contrasenia))? u: null;
		}
		else {
			return null;
		}

	}
	@Override
	public Boolean CrearNuevoUsuario(String nombre, String correo, String username, String contrasenia, List<Tema> temas) {
		
		if(repo.getByUsername(username) != null) {
			return false;
		}
		
		Usuario u = new Usuario(nombre, correo, username, contrasenia);
		int usuarioID = repo.add(u);
		for (Tema tema : temas) {
			System.out.println("ID del tema " + tema.getNombre() + " : " + tema.getTemaID());
			temaRepo.agregarTemaAUsuario(usuarioID, tema.getTemaID());
		}
		return true;
	}

}
