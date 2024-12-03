package logica;

import java.util.Date;

public class Respuesta extends Zeta{
	
	private Zeta zetaAContestar;

	public Respuesta(int id, Usuario usuario, String body, Date fecha,
			Zeta zetaAContestar, int likesCantity, Boolean likedByUser) {
		//super(id, usuario, body, fecha);
		super(id, usuario, body, fecha,"", 0, zetaAContestar.getTema(), null, likedByUser);
		this.zetaAContestar = zetaAContestar;
	}

	public Respuesta( Usuario usuario, String body, Date fecha,
			Zeta zetaAContestar) {
		super(usuario, body, fecha);
		this.zetaAContestar = zetaAContestar;
	}

	public Zeta getZetaAContestar() {
		return zetaAContestar;
	}

	public void setZetaAContestar(Zeta zetaAContestar) {
		this.zetaAContestar = zetaAContestar;
	}
}
