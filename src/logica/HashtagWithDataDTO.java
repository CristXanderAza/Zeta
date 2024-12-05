package logica;

public class HashtagWithDataDTO {

	private int id;
	private String nombre;
	private int cantidadPost;

	public HashtagWithDataDTO(int id, String nombre, int cantidadPost) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidadPost = cantidadPost;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadPost() {
		return cantidadPost;
	}

	public void setCantidadPost(int cantidadPost) {
		this.cantidadPost = cantidadPost;
	}

	
}
