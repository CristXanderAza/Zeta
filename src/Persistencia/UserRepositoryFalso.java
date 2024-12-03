package Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import logica.Usuario;

public class UserRepositoryFalso implements IUserRepository{
	
    private static Usuario placeHolder = new Usuario(0, "Admin", "Admin",  "Admin",  "Admin", true);
    private static List<Usuario> placeHolders = new ArrayList<>(Arrays.asList(
    	    new Usuario(3, "Admin", "Admin", "Admin", Usuario.encriptar("Admin"), true),
    	    new Usuario(4, "Cristopher", "Aza", "Crist", Usuario.encriptar("Prueba"), true)
    	));
    
	@Override
	public void add(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getByUsername(String username) {
		// TODO Auto-generated method stub
		return placeHolders.stream().filter(u -> u.getUsername().equals(username)).findFirst()
                .orElse(null);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getByID(int id) {
		// TODO Auto-generated method stub
		for (Usuario usuario : placeHolders) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		
		
		return null;
	}

}
