package logica;

import java.util.Date;

public class Respuesta extends Zeta{
	
	private Zeta zetaAContestar;
	
	
	
	public Respuesta(int id, Usuario usuario, String body, Date fecha,
			Zeta zetaAContestar) {
		super(id, usuario, body, fecha);
		this.zetaAContestar = zetaAContestar;
	}

	public Respuesta( Usuario usuario, String body, Date fecha,
			Zeta zetaAContestar) {
		super(usuario, body, fecha);
		this.zetaAContestar = zetaAContestar;
	}


}
