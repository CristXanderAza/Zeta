package logica;

import java.util.List;

public class Hilo {
	
	private int id;
	private List<Zeta> zetas;
	
	public Hilo(int id, List<Zeta> zetas) {
		super();
		this.id = id;
		this.zetas = zetas;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Zeta> getZetas() {
		return zetas;
	}

	public void setZetas(List<Zeta> zetas) {
		this.zetas = zetas;
	}
	
}
