package UI.PublicacionesComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Persistencia.UserRepository;
import logica.Notificacion;
import logica.Usuario;

public class NotificacionesBasicView extends JPanel {
	
	
    private Notificacion notificacion ;
	private String mensaje;
	private int emisor;
	private String tipo;
	private String fecha;
		

private static final long serialVersionUID = 1L;

/**
 * Create the panel.
 */
public NotificacionesBasicView(Notificacion notificacion) {
	this.notificacion= notificacion;
	this.emisor = notificacion.getId_emisor();
	this.tipo = notificacion.getTipo();
	this.fecha = notificacion.getFecha().toString();
	initialize(notificacion);

}


 

private void initialize(Notificacion notificacion) {
	
	if (tipo == "LikeComentario")
	{ 
		mensaje = "" + UserRepository.obtenerPorID(emisor).getUsername() + " " + "le ha dado like a tu comentario";
	}
	if (tipo == "MencionZeta" )
	{
		mensaje = "" + UserRepository.obtenerPorID(emisor).getUsername() + " " + "te ha mencionado en zeta";
	}
	else if (tipo == "MencionComentario" )
	{
		mensaje = "" + UserRepository.obtenerPorID(emisor).getUsername() + " " +"te ha mencionado en un comentario";
	}
	else if (tipo == "Comentario")
	{
		mensaje = "" + UserRepository.obtenerPorID(emisor).getUsername() + " " + "ha comentado en tu zeta";
	}
	else {
		mensaje = "" + UserRepository.obtenerPorID(emisor).getUsername() + " " + "le ha dado like a tu comentario";
	}
	
	
	
	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	JPanel panel_1 = new JPanel();
	
	add(panel_1);
	panel_1.setBorder(new TitledBorder(null, fecha , TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
	panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
	panel_1.setPreferredSize(new Dimension(400, 130));
	
	JPanel panel = new JPanel();
	panel_1.add(panel);
	
	JLabel lblNewLabel = new JLabel("<html>" + mensaje  + "</html>");
	lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
	lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	panel.add(lblNewLabel);
	
	JPanel panel_2 = new JPanel();
	panel_1.add(panel_2);
	panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
	
	

}}
