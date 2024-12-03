package logica.Servicios;

import java.util.Date;
import java.util.List;

import Persistencia.ILikeRepository;
import Persistencia.IRespuestaRepository;
import logica.LikeInteraccion;
import logica.Respuesta;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public class RespuestaServicio implements IRespuestasServicio {
	

	private IRespuestaRepository respuestaRepo;
	private ILikeRepository likeRespRepo;

	
	public RespuestaServicio(IRespuestaRepository respuestaRepo, ILikeRepository likeRespRepo) {
		super();
		this.respuestaRepo = respuestaRepo;
		this.likeRespRepo = likeRespRepo;
	}

	@Override
	public Respuesta responder(ZetaInsertDTO dto, Usuario u, Zeta z) {
		// TODO Auto-generated method stub
		Respuesta r = new Respuesta(u, dto.getBody(), new Date(),z);
		respuestaRepo.agregarRespuesta(r);
		return r;
		
	}

	@Override
	public void darLike(Respuesta r, Usuario actual) {
		// TODO Auto-generated method stub
		LikeInteraccion li = r.darLike(actual);
		likeRespRepo.AddLike(actual.getId(), r.getId());
		respuestaRepo.darLike(li);
	}

	@Override
	public void quitarLike(Respuesta r, Usuario actual) {
		// TODO Auto-generated method stub
		r.quitarLike(actual);
		likeRespRepo.DeleteLike(actual.getId(), r.getId());
		respuestaRepo.quitarLike(actual, r);
	}

	@Override
	public Respuesta getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Respuesta> getRespuestasDeZeta(Zeta z) {
		// TODO Auto-generated method stub
		return respuestaRepo.obtenerRespuestasDeZeta(z);
	}

	@Override
	public void update(Respuesta r, String newBody) {
		// TODO Auto-generated method stub
		r.setBody(newBody);
		respuestaRepo.actualizarRespuesta(r);
	}

	@Override
	public void delete(Respuesta r) {
		// TODO Auto-generated method stub
		respuestaRepo.borrarRespuesta(r.getId());
	}
	



}
