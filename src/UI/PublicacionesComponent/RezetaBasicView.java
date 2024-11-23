package UI.PublicacionesComponent;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import UI.ZweetViewer;
import logica.Zeta;

public class RezetaBasicView extends JPanel {

	private static final long serialVersionUID = 1L;
	private Zeta zeta;
	private ZweetViewer contenedor;
	private Boolean activarBotones;

	/**
	 * Create the panel.
	 */
	public RezetaBasicView() {

		initialize("Admin","Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea.",
				"Fulano","Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea.");
	}
	
	public RezetaBasicView(Zeta z, ZweetViewer contenedor, Boolean activar) {

		initialize(z.getUsuario().getUsername(), z.getParent().getUsuario().getUsername()
				, z.getBody(), z.getParent().getBody());
		this.contenedor = contenedor;
		this.activarBotones = activar;
	}
	
	
	
	private void initialize(String autor, String autorRef, String body, String bodyRef) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "@" + autor, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setPreferredSize(new Dimension(400, 200));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("<html>"+ body.replace("\n", "<br/>") +"</html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "@" + autorRef, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("<html>"+ bodyRef.replace("\n", "<br/>") +"</html>");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new BoxLayout(panel_2_1, BoxLayout.X_AXIS));
		
		JButton btnLike = new JButton("Like");
		btnLike.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2_1.add(btnLike);
		
		JButton btnComentar = new JButton("Comentar");
		btnComentar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2_1.add(btnComentar);
		
		JButton btnRezweet = new JButton("Rezweet");
		btnRezweet.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2_1.add(btnRezweet);
		
		JButton btnNewButton = new JButton("Perfil");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2_1.add(btnNewButton);
	}

}
