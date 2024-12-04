package logica;

import java.sql.Date;

public class Notificacion {
	private int id_receptor;
	private int id_emisor;
	private int id_elemento;
	private String tipo;
	private Date fecha;

	public Notificacion(int idReceptor, int idEmisor, int idelemento, String tipo, Date fecha) {
		setId_receptor(idReceptor);
		setId_emisor(idEmisor);
		setId_elemento(idelemento);
		setTipo(tipo);
		setFecha(fecha);
		
	}
	
	//Getters and setters
	public int getId_elemento() {
		return id_elemento;
	}

	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId_receptor() {
		return id_receptor;
	}

	public void setId_receptor(int id_receptor) {
		this.id_receptor = id_receptor;
	}

	public int getId_emisor() {
		return id_emisor;
	}

	public void setId_emisor(int id_emisor) {
		this.id_emisor = id_emisor;
	}

}
