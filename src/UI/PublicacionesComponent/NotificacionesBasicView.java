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

import logica.Usuario;

public class NotificacionesBasicView extends JPanel {
	
	
	
 private Usuario Cuenta;
 private Usuario usuario_externo;
 boolean like;
 boolean comment;
 boolean follow;
 
private String mensaje = "Texto ejemplo";
			

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public NotificacionesBasicView() {
		
		initialize();

	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		
		JPanel panel_1 = new JPanel();
		
		add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Hoy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.setPreferredSize(new Dimension(400, 130));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("<html>" + mensaje + "</html>");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		

		
		JButton btndetalles = new JButton("Ver más detalles");
		btndetalles.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(btndetalles);
		
		btndetalles.addActionListener(e -> {
			System.out.println("ya viste los detalles");
	
		});
		
		
		btndetalles.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(btndetalles);
		

	}
	

	
	

	
	
}
