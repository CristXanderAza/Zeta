package logica.Servicios;

import java.util.Date;
import java.util.List;

import Persistencia.IZetasRepository;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public class ZetaServicio implements IZetasServicio {

	private IZetasRepository zetaRepository;
	
	public ZetaServicio(IZetasRepository zRepo) {
		zetaRepository = zRepo;
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
	@Override
	public Zeta agregarZeta(ZetaInsertDTO z) {
		// TODO Auto-generated method stub
		Zeta zt = new Zeta(z.getUsuario(), z.getBody(), new Date());
		if(!z.getImageReference().isBlank()) {
			zt.setImageReference(z.getImageReference());
		}
		return zt;
	}
	@Override
	public List<Zeta> getByUserInTimeLapse(Usuario u, Date inicio, Date finall) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Zeta> getZetaDeSeguidos(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Zeta z) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Zeta z) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Zeta rezetear(Zeta padre, ZetaInsertDTO dto) {
		// TODO Auto-generated method stub
		Zeta z = padre.rezetear(dto.getUsuario(), dto.getBody(), new Date());
		zetaRepository.agregarZeta(z);
		return z;
	}

}
