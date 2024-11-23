package UI.PublicacionesComponent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.Zeta;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class ZweetBasicView extends JPanel {

	private static final long serialVersionUID = 1L;
	private Zeta zeta;

	/**
	 * Create the panel.
	 */
	public ZweetBasicView(Zeta zeta) {
		
		this.zeta = zeta;
		
		initialize(zeta.getUsuario().getUsername(), zeta.getBody().toString());
	}
	
	public ZweetBasicView() {
		
		this.zeta = null;
		
		initialize("Admin", "Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea." );
	}
	
	
	
	
	private void initialize(String autor, String body) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "@" + autor, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel_1.setPreferredSize(new Dimension(400, 130));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("<html>"+body.replace("\n", "<br/>") + "</html>");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnLike = new JButton("Like");
		btnLike.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(btnLike);
		
		JButton btnComentar = new JButton("Comentar");
		btnComentar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(btnComentar);
		
		JButton btnRezweet = new JButton("Rezweet");
		btnRezweet.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(btnRezweet);
		
		JButton btnNewButton = new JButton("Perfil");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(btnNewButton);
	}
	
	
    public static String insertarSaltoDeLinea(String texto, int longitud) {
        // Usamos un StringBuilder para manipular el texto eficientemente
        StringBuilder resultado = new StringBuilder(texto);

        // Variable para mantener el índice donde insertar "<br/>"
        int indice = longitud;

        while (indice < resultado.length()) {
            resultado.insert(indice, "<br/>");
            // Ajustamos el índice al siguiente punto, considerando la longitud de "<br/>"
            indice += longitud + "<br/>".length();
        }

        return resultado.toString();
    }
}
