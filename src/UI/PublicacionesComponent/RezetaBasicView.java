package UI.PublicacionesComponent;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Base.App;
import UI.ZweetViewer;
import logica.Respuesta;
import logica.Zeta;

public class RezetaBasicView extends JPanel {

	private static final long serialVersionUID = 1L;
	private Zeta zeta;
	private ZweetViewer contenedor;
	private Boolean activarBotones;
	private JButton btnLike;


	/**
	 * Create the panel.
	 */
	public RezetaBasicView() {

		initialize("Admin","Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea.",
				"Fulano","Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea.");
	}
	
	public RezetaBasicView(Zeta z, ZweetViewer contenedor, Boolean activar) {
		this.zeta = z;
		this.contenedor = contenedor;
		
		this.activarBotones = activar;
		initialize(z.getUsuario().getUsername(), z.getParent().getUsuario().getUsername()
				, z.getBody(), z.getParent().getBody());

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
		
		btnLike = new JButton("Like: " + zeta.getLikesCantity());
		updateLikeButtonApareance();
		btnLike.setEnabled(activarBotones);
		btnLike.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnLike.addActionListener(e -> {
			darLike();
			
		});
		panel_2_1.add(btnLike);
		
		if(!(zeta instanceof Respuesta)) {
			JButton btnComentar = new JButton("Comentar");
			btnComentar.addActionListener(e -> responder());
			btnComentar.setEnabled(activarBotones);
			btnComentar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			panel_2_1.add(btnComentar);
			
			JButton btnRezweet = new JButton("Rezeta");
			btnRezweet.setEnabled(activarBotones);

			btnRezweet.addActionListener(e -> {
				System.out.println("Rezeta");
				contenedor.Rezetear(zeta);
			});
			btnRezweet.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			panel_2_1.add(btnRezweet);
			
			
			
			JButton btnVerPadre = new JButton("Padre");
			btnVerPadre.setEnabled(activarBotones);
			if(zeta.getParent().getImageReference() != null) {
				btnVerPadre.addActionListener(e -> {
					System.out.println("Rezeta");
					contenedor.Rezetear(zeta.getParent());
				});
				btnVerPadre.setFont(new Font("Century Gothic", Font.PLAIN, 12));
				panel_2_1.add(btnVerPadre);
			}

			
		}
		/*
		if (zeta.getBody().contains("#") ||zeta.getBody().contains("@") ) {
			JButton btnRef = new JButton("Ver Referencia");
			btnRef.setEnabled(activarBotones);

			btnRef.addActionListener(e -> {
				System.out.println("Rezeta");
				contenedor.Rezetear(zeta);
			});
			btnRef.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			panel_2_1.add(btnRef);
		}
		*/
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(e -> App.visualizarPerfil(zeta.getUsuario().getId()));
		btnPerfil.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2_1.add(btnPerfil);
	}

	
    private void darLike() {
    	if(zeta instanceof Respuesta) {
    		if(!zeta.getLikedByUser()) {
	    		contenedor.darLikeResp((Respuesta)zeta);    		
	    	}
	    	else {
	    		contenedor.quitarLikeResp((Respuesta)zeta);
	    	}
    	}
    	else {
    		if(!zeta.getLikedByUser()) {
	    		contenedor.darLike(zeta);    		
	    	}
	    	else {
	    		contenedor.quitarLike(zeta);
	    	}
    	}
	    	
    	updateLikeButtonApareance();
    	
    }
    
    public void updateLikeButtonApareance() {
    	if(zeta.getLikedByUser()) {
    		
    		btnLike.setForeground(Color.blue);
    		btnLike.setText("Like: " + zeta.getLikesCantity());
    		System.out.println("Encendido");
    		
    	}
    	else {
    		
    		btnLike.setForeground(Color.black);
    		btnLike.setText("Like: " + zeta.getLikesCantity());
    		System.out.println("Apagado");
    	}
    }
    
    private void responder() {
    	contenedor.Responder(zeta);
    }
}
