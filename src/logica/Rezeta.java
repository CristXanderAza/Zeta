package logica;

import java.util.Date;

public class Rezeta extends Zeta{
	
	private Zeta zetaOriginal;

	public Rezeta( Usuario usuario, Date fecha, Zeta zetaOriginal) {
		super( usuario, "", fecha);
		this.zetaOriginal = zetaOriginal;
	}
	
	public Zeta getZetaOriginal() {
		return zetaOriginal;
	}
}
