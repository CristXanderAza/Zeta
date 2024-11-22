package logica.Servicios;

import java.util.Date;
import java.util.List;

import logica.Quote;
import logica.Rezeta;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public interface IQuoteRepository {

	public Quote add(ZetaInsertDTO dto, Zeta z);
	
	public List<Quote> getQuoteDeZeta(Zeta z);

	public List<Quote> getQuoteDeUsuarioInTiemLapse(Usuario u, Date inicio, Date finall);
	
	public List<Quote> getQuotePorSeguiendo(Usuario u);
	
	public void delete(Rezeta rz);
}
