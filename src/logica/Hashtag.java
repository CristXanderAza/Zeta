package logica;

public class Hashtag {

	private int ID;
	private String nombre;
	
	public Hashtag(int iD, String nombre) {
		super();
		ID = iD;
		this.nombre = nombre;
	}
	
	public Hashtag(String nombre) {
		super();
		
		this.nombre = nombre;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
