package Persistencia;

import java.util.List;

import logica.Hashtag;
import logica.Tema;

public interface IHashtagRepository {
	public void agregarHashtag(Hashtag h);
	public Hashtag obtenerPorId(int idHashtag);
	public List<Hashtag> obtenerTodos();
    public void actualizar(Hashtag h);
    public void eliminar(int idHashtag);
    public void agregarZetaAHashtag(int idZeta, int idHashtag);
}
