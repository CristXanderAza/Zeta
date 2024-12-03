package Persistencia;

public interface IFollowersRepository {
	public void add(int idSeguido, int idSeguidor);
	
	public void delete(int idSeguido, int idSeguidor);
}
