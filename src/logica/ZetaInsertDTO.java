package logica;

public class ZetaInsertDTO {

	private String body;
	private String imageReference;
	private Tema tema;
	private Usuario usuario;
	
	public ZetaInsertDTO(String body, String imageReference, Usuario usuario, Tema t) {
		super();
		this.body = body;
		this.imageReference = imageReference;
		this.tema = t;
		this.usuario = usuario;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImageReference() {
		return imageReference;
	}

	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
