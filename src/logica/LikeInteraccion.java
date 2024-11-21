package logica;

public class LikeInteraccion {
	private int interaccionId;
	private Zeta zeta;
	private Usuario usuario;

	public LikeInteraccion(int interaccionId,  Zeta zeta, Usuario usuario) {
		super();
		this.interaccionId = interaccionId;
		this.zeta = zeta;
		this.usuario = usuario;
	}
	
	public LikeInteraccion(Zeta zeta, Usuario usuario) {
		super();
		this.zeta = zeta;
		this.usuario = usuario;
	}
	
	public int getInteraccionId() {
		return interaccionId;
	}

	public void setInteraccionId(int interaccionId) {
		this.interaccionId = interaccionId;
	}



	public Zeta getZeta() {
		return zeta;
	}

	public void setZeta(Zeta zeta) {
		this.zeta = zeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
