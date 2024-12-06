package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Persistencia.ITemaRepository;
import logica.Usuario;
import logica.Zeta;
import logica.Servicios.IRespuestasServicio;
import logica.Servicios.IZetasServicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.BoxLayout;

public class ScrollZetaViewer {

	private JFrame frame;
	private ZweetViewer zv;
	private List<Zeta> zetas;
	private String titulo;
	//private ITemaRepository temaRepositorio;
	private IZetasServicio zetaServicio;
	private IRespuestasServicio respuestaServicio;
	
	
	public ScrollZetaViewer(List<Zeta> zetas, String titulo, 
			IZetasServicio zetaServicio, IRespuestasServicio respuestaServicio) {
		super();
		this.zetas = zetas;
		this.titulo = titulo;
		this.zetaServicio = zetaServicio;
		this.respuestaServicio = respuestaServicio;
		initialize();
		frame.setVisible(true);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrollZetaViewer window = new ScrollZetaViewer(null, null, null, null);
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
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 511);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblejemplo = new JLabel(titulo);
		lblejemplo.setForeground(Color.WHITE);
		lblejemplo.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		panel.add(lblejemplo);
		
		JPanel ZPanel = new JPanel();
		frame.getContentPane().add(ZPanel, BorderLayout.CENTER);
		ZPanel.setLayout(new BoxLayout(ZPanel, BoxLayout.X_AXIS));
		
		
		zv = new ZweetViewer(Usuario.getActual(), zetaServicio, zetas, respuestaServicio);
		zv.setPreferredSize(new Dimension(20, 200));
		ZPanel.add(zv);
	}

}
