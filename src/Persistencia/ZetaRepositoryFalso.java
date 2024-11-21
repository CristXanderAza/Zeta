package Persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Usuario;
import logica.Zeta;

public class ZetaRepositoryFalso implements IZetasRepository {

	
	private List<Zeta> zetas;
	private static Usuario placeHolder = new Usuario(0, "Admin", "Admin",  "Admin",  "Admin");
	
	public ZetaRepositoryFalso() {
		zetas = new ArrayList<Zeta>();
		agregarPlaceHolders();
	}
	
    public void agregarPlaceHolders() {
        for (int i = 0; i < 10; i++) {
            Zeta z = new Zeta(placeHolder,
            		"Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea.", new Date());
            zetas.add(z);
        }
    }
	
	@Override
	public void agregarZeta(Zeta z) {
		// TODO Auto-generated method stub
		zetas.add(z);
	}

	@Override
	public Zeta getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zeta> getAll() {
		// TODO Auto-generated method stub
		return zetas;
	}

	@Override
	public void Update(Zeta z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Zeta z) {
		// TODO Auto-generated method stub
		
	}

}
