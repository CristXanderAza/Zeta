package logica;

public class Busqueda {
	private int idElemento;
	private String nombre;
	private String tipo;
	private int cantidad;

	public Busqueda(int idElemento, String nombre, String tipo, int cantidad) {
		setIdElemento(idElemento);
		setNombre(nombre);
		setTipo(tipo);
		setCantidad(cantidad);
	}
	
	//Getters and setters
	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
