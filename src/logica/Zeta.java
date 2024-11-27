package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zeta {

	protected int id;
	protected Usuario usuario;
	protected String body;
	protected Date fechaPublicacion;
	protected Zeta parent;
	protected Tema tema;
	private int hiloID;
	protected Hilo hilo;
	protected String imageReference;
	protected int imageID;
	protected int likesCantity;
	protected List<Usuario> rezetas;
	protected List<Usuario> likes;
	protected List<Respuesta> respuestas;
	private Boolean likedByUser;
	

	public Zeta(int id, Usuario usuario, String body, Date fecha,String image, int hiloID, Tema tema, Zeta parent, Boolean likedByUser) {
		this.id = id;
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.tema = tema;
		this.parent = parent;
		this.hiloID = hiloID;
		this.imageReference = image;
		this.likedByUser = false;
		this.likes = new ArrayList<Usuario>();
	}
	
	public Zeta(int id, Usuario usuario, String body, Date fecha) {
		this.id = id;
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = null;
		this.imageReference ="";
		this.likedByUser = false;
		this.likes = new ArrayList<Usuario>();
	}
	
	public Zeta( Usuario usuario, String body, Date fecha, Zeta parent) {
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = parent;
		this.imageReference ="";
		this.likedByUser = false;
		this.likes = new ArrayList<Usuario>();
	}
	
	public Zeta(Usuario usuario, String body, Date fecha) {
		this.usuario = usuario;
		this.body = body;
		this.fechaPublicacion = fecha;
		this.parent = null;
		this.imageReference ="";
		this.likedByUser = false;
		this.likes = new ArrayList<Usuario>();
	}
	
	public LikeInteraccion darLike(Usuario u) {
		likes.add(u);
		likesCantity++;
		likedByUser = true;
		return new LikeInteraccion(this, u);
	}
	
	public void quitarLike(Usuario u) {
		likes.remove(u);
		likesCantity-=1;
		likedByUser = false;
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

	
	public int getLikesCantity() {
		return likesCantity;
	}

	public void setLikesCantity(int likesCantity) {
		this.likesCantity = likesCantity;
	}

	public Boolean getLikedByUser() {
		return likedByUser;
	}

	public void setLikedByUser(Boolean likedByUser) {
		this.likedByUser = likedByUser;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public int getHiloID() {
		return hiloID;
	}

	public void setHiloID(int hiloID) {
		this.hiloID = hiloID;
	}

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public Hilo getHilo() {
		return hilo;
	}

	public void setHilo(Hilo hilo) {
		this.hilo = hilo;
	}

}
