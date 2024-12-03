package Persistencia;

import java.util.List;

import logica.Busqueda;

public interface IBusquedaRepository {
	public List<Busqueda> RealizarBusqueda(String busqueda);
}
