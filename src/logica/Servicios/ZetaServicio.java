package logica.Servicios;

import java.util.List;

import Persistencia.IZetasRepository;
import logica.Zeta;

public class ZetaServicio implements IZetasServicio {

	private IZetasRepository zetaRepository;
	
	public ZetaServicio(IZetasRepository zRepo) {
		zetaRepository = zRepo;
	}
	@Override
	public void agregarZeta(Zeta z) {
		// TODO Auto-generated method stub
		zetaRepository.agregarZeta(z);
	}

	@Override
	public Zeta getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zeta> getAll() {
		// TODO Auto-generated method stub
		return zetaRepository.getAll();
	}

}
