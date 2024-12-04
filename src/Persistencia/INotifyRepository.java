package Persistencia;

import java.util.List;

import logica.Notificacion;

public interface INotifyRepository {
	
	public List<Notificacion> ObtenerNotificaiones(int idReceptor);
}
