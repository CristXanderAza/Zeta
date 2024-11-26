package Persistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import logica.Usuario;

public class UserRepositoryFalso implements IUserRepository{
	
    private static Usuario placeHolder = new Usuario(0, "Admin", "Admin",  "Admin",  "Admin", true);
    private static List<Usuario> placeHolders = new ArrayList<>(Arrays.asList(
    	    new Usuario(0, "Admin", "Admin", "Admin", "Admin", true),
    	    new Usuario(1, "Cristopher", "Aza", "Crist", "Prueba", true)
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

}
