package logica;

import java.util.Date;

public class Quote extends Zeta {

	private Zeta zetaOriginal;

	public Quote( Usuario usuario, String body, Date fecha,  Zeta zetaOriginal) {
		super( usuario, body, fecha);
		this.zetaOriginal = zetaOriginal;
	}
	
	public Zeta getZetaOriginal() {
		return zetaOriginal;
	}
	
}
