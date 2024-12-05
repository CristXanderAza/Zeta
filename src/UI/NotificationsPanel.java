package UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import Persistencia.NotifyRepository;
import UI.PublicacionesComponent.NotificacionesBasicView;
import logica.Notificacion;
import logica.Servicios.NotificacionesServicio;

public class NotificationsPanel extends JPanel {
	
	public JPanel panel_3;
	private NotificacionesServicio notiservicio = new NotificacionesServicio(new NotifyRepository(), this);
	private Notificacion notify;
	private int idReceptor;
	

	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				

    }
	
	/**
	 * Create the frame.
	 */
	
	public NotificationsPanel(Notificacion notify) {
		
		this.notify =notify;
		
		if (this.notify != null) {
            this.idReceptor = notify.getId_receptor();
        } else {
            throw new IllegalArgumentException("La notificación no puede ser null");
        }

	}
	
	public NotificationsPanel() {
		
		
		
		setBounds(100, 100, 500, 590);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(52, 52, 52));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.setForeground(Color.WHITE);
		lblNotificaciones.setBackground(SystemColor.controlDkShadow);
		lblNotificaciones.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblNotificaciones.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.add(lblNotificaciones);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(192, 192, 192));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		//Panel del ScrollPane
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 =  new JScrollPane();
		panel_2.add(scrollPane_1);
		
        panel_3 = new JPanel();
		scrollPane_1.setViewportView(panel_3);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		
		
		notiservicio.Mostrarnotificaciones(idReceptor);
		
		
		
		
	}

}

	

    

