package UI.PublicacionesComponent;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import logica.Zeta;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class ZetaImagenView extends JPanel {

	private static final long serialVersionUID = 1L;
	private Zeta zeta;

	/**
	 * Create the panel.
	 */
	public ZetaImagenView() {
		
		initialize("@Admin", "Reguetonero local se vuelve profesor del ITLA."
				, "C:\\Users\\pluto\\Downloads\\MrFreidy.png");
	}
	
	public ZetaImagenView(Zeta z) {
		this.zeta = z;
		initialize(z.getUsuario().getUsername(), z.getBody(), z.getImageReference());
	}
	
	private void initialize(String autor, String body, String rutaImagen) {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "@" + autor, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setPreferredSize(new Dimension(400, 324));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("<html>"+ body.replace("\n", "<br/>") + "</html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
	
        lblNewLabel_1.setIcon(generarImagen(rutaImagen, lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight()));
		
        
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pluto\\OneDrive\\Escritorio\\ef011ace6f36b6c1d00d476808362cbd.jpg"));
		scrollPane.setViewportView(lblNewLabel_1);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
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
	
	private ImageIcon generarImagen(String ruta, int width, int heigth) {
        ImageIcon icon = new ImageIcon(ruta);

        // Ajustar la imagen al tamaño del JLabel
        Image image = icon.getImage(); // Obtener el objeto Image
        Image scaledImage = image.getScaledInstance(700, 300, Image.SCALE_SMOOTH); // Escalar
        ImageIcon scaledIcon = new ImageIcon(scaledImage); 
        return scaledIcon;
	}

}
