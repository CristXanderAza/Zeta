package logica.Servicios;

import java.util.Date;
import java.util.List;

import Persistencia.IZetasRepository;
import logica.LikeInteraccion;
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
			int imageID = zetaRepository.agregarImagen(z.getImageReference());
			zt.setImageID(imageID);
			zt.setImageReference(z.getImageReference());
		}
		zetaRepository.agregarZeta(zt);
		return zt;
	}
	
	/*Notas de Cristopher:
	 * Para el repositorio de los Zetas es necesario tres metodos relacionados a Likes
	 * -Uno para confirmar si el usuario actual le ha dado like
	 * - otro para insertar el like por parte del usuario
	 *  - y otro para quitar el like
	 */
	
	
	@Override
	public void darLike(Zeta z, Usuario u) {
		LikeInteraccion li= z.darLike(u);
		zetaRepository.darLike(li);
	}
	
	@Override
	public void quitarLike(Zeta z, Usuario u) {
		z.quitarLike(u);
		zetaRepository.quitarLike(u, z);
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
