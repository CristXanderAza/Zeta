package logica.Servicios;

import java.util.List;

import logica.Tema;
import logica.Usuario;

public interface IUserServicio {
	
	public Usuario iniciarSesion(String userName, String contrasenia);
	
	public Boolean CrearNuevoUsuario(String nombre, String correo, String username, String contrasenia, List<Tema> temas);
	
	
	
}
