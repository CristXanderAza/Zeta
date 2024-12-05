package logica.Servicios;

import java.util.List;

import javax.swing.JPanel;

import Persistencia.NotifyRepository;
import UI.NotificationsPanel;
import UI.PublicacionesComponent.NotificacionesBasicView;
import logica.Notificacion;
import logica.Usuario;

public class NotificacionesServicio {
	
	private NotificationsPanel panelnoti;
	private NotifyRepository  notify;
	private Notificacion notificacion;
	private int receptor;
	

	
	public NotificacionesServicio( NotifyRepository  notify, NotificationsPanel panelnoti ){
		
		this.panelnoti = panelnoti;
		this.receptor = Usuario.getActual().getId();
		
		this.notify = notify;
		/*
		if (this.notify != null) {
            this.receptor = notificacion.getId_receptor();
        } else {
            throw new IllegalArgumentException("La notificación no puede ser null");
        }
		*/
	}
	
	
	public void Mostrarnotificaciones (int id_receptor)
	{
		JPanel panel3 = panelnoti.panel_3;
		
		List<Notificacion> allnotification = notify.ObtenerNotificaiones(receptor);
		
		for (Notificacion notificacion : allnotification) {
			
			NotificacionesBasicView panelNotificacion = new NotificacionesBasicView (notificacion);
			panel3.add(panelNotificacion);
	        }

	      
		panel3.repaint();
			
	
		
	}
	
	

}
