package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

import Persistencia.ITemaRepository;
import Persistencia.UserRepository;
import logica.Usuario;
import logica.Zeta;
import logica.Servicios.IRespuestasServicio;
import logica.Servicios.IUserServicio;
import logica.Servicios.IZetasServicio;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;

public class ProfileViewPanel {

	private JFrame frame;
	private ZweetViewer zv;
	private List<Zeta> zetas;
	private String titulo;
	private int seguidores;
	//private ITemaRepository temaRepositorio;
	private IZetasServicio zetaServicio;
	private IRespuestasServicio respuestaServicio;
	private IUserServicio usuarioServicio;
	private Boolean isFollow;
	private JButton btnSeguir;
	private JLabel lblNewLabel_1;
	private int UserId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileViewPanel window = new ProfileViewPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfileViewPanel() {
		initialize();
	}

	public ProfileViewPanel(List<Zeta> zetas, String titulo, int seguidores, IZetasServicio zetaServicio,
			IRespuestasServicio respuestaServicio, IUserServicio usuarioServicio, Boolean b, int userID) {
		super();
		this.zetas = zetas;
		this.titulo = titulo;
		this.seguidores = seguidores;
		this.zetaServicio = zetaServicio;
		this.respuestaServicio = respuestaServicio;
		this.usuarioServicio = usuarioServicio;
		this.isFollow = b;
		this.UserId = userID;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 427);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBorder(new TitledBorder(null, ".", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("@" + titulo);
		panel_4.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		
		 lblNewLabel_1 = new JLabel(seguidores + " seguidores");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_4.add(lblNewLabel_1);
		
		btnSeguir = new JButton("Seguir");
		btnSeguir.addActionListener(e -> seguir());
		btnSeguir.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		botonSeguirUpdate();
		panel_4.add(btnSeguir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel ZPanel = new JPanel();
		ZPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(ZPanel);
		ZPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		ZPanel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		zv = new ZweetViewer(Usuario.getActual(), zetaServicio, zetas, respuestaServicio);
		zv.setPreferredSize(new Dimension(20, 200));
		ZPanel.add(zv);
	}
	
	
	private void botonSeguirUpdate() {
		if(isFollow) {
			btnSeguir.setText("Siguiendo :)");
			btnSeguir.setForeground(Color.BLUE);
		}
		else {
			btnSeguir.setText("Seguir      ");
			btnSeguir.setForeground(Color.black);
		}
	}
	
	private void seguir() {
		if(!isFollow) {
			UserRepository.SeguirUsuario(Usuario.getActual().getId(), UserId);
			seguidores++;
			lblNewLabel_1.setText(seguidores + " seguidores");
			isFollow = true;
		}
		else {
			UserRepository.dejarDeseguirUsuario(Usuario.getActual().getId(), UserId);
			seguidores--;
			lblNewLabel_1.setText(seguidores + " seguidores");
			isFollow = false;
		}
		botonSeguirUpdate();
	}
	
	

}
