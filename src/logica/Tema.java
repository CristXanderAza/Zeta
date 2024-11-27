package logica;

public class Tema {
	
	private int temaID;
	private String Nombre;
	
	public Tema(int temaID, String nombre) {
		super();
		this.temaID = temaID;
		Nombre = nombre;
	}
	
	public int getTemaID() {
		return temaID;
	}

	public void setTemaID(int temaID) {
		this.temaID = temaID;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	
}
