package logica;

import java.util.Date;
import java.util.List;

public class Zeta {

	protected int id;
	protected Usuario usuario;
	protected String body;
	protected Date fechaPublicacion;
	protected Zeta parent;

	protected String imageReference;

	
	protected List<Usuario> rezetas;
	protected List<Usuario> likes;
	protected List<Respuesta> respuestas;
	
	
	
	public Zeta(int id, Usuario usuario, String body, Date fecha, Zeta parent) {
		this.id = id;
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = parent;
		this.imageReference ="";
		
	}
	
	public Zeta(int id, Usuario usuario, String body, Date fecha) {
		this.id = id;
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = null;
		this.imageReference ="";
		
	}
	
	public Zeta( Usuario usuario, String body, Date fecha, Zeta parent) {
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = parent;
		this.imageReference ="";
	}
	
	public Zeta(Usuario usuario, String body, Date fecha) {
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = null;
		this.imageReference ="";
	}
	
	public LikeInteraccion darLike(Usuario u) {
		likes.add(u);
		return new LikeInteraccion(this, u);
	}
	
	public Respuesta comentar(String Body, Usuario u) {
		Respuesta r = new Respuesta(u, Body, new Date(), this);
		respuestas.add(r);
		return r;
	}
	
	public Zeta rezetear(Usuario u, String body, Date d) {
		Zeta z = new Zeta(u,body,d);
		z.setParent(this);
		return z;
	}
	
	public static Zeta placeholder() {
		return new Zeta(Usuario.placeholder(), "Lorem Ipsum", new Date());
	}
	
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public Zeta getParent() {
		return parent;
	}
	public void setParent(Zeta parent) {
		this.parent = parent;
	}

	public List<Usuario> getRezetas() {
		return rezetas;
	}
	public void setRezetas(List<Usuario> rezetas) {
		this.rezetas = rezetas;
	}
	public List<Usuario> getLikes() {
		return likes;
	}
	public void setLikes(List<Usuario> likes) {
		this.likes = likes;
	}
	public List<Respuesta> getComentarios() {
		return respuestas;
	}
	public void setComentarios(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	
	public String getImageReference() {
		return imageReference;
	}

	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
}
