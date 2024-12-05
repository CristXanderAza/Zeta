package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UI.PublicacionesComponent.ScrollExplorer;
import logica.Busqueda;
import logica.Servicios.BusquedaServicio;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.BoxLayout;

public class ScrollUserFollow {

	private JFrame frame;
	private BusquedaServicio buscarServicio;
	private ScrollExplorer scrollExplorer ; 
	private List<Busqueda> bus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrollUserFollow window = new ScrollUserFollow();
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
	public ScrollUserFollow() {
		initialize();
	}
	
	public ScrollUserFollow(BusquedaServicio buscarServicio, List<Busqueda> bus) {
		super();
		this.buscarServicio = buscarServicio;
		this.bus = bus;
		initialize();
		frame.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 468);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblejemplo = new JLabel("Seguidos");
		lblejemplo.setForeground(Color.WHITE);
		lblejemplo.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		panel.add(lblejemplo);
		
		JPanel panelTarget = new JPanel();
		frame.getContentPane().add(panelTarget, BorderLayout.CENTER);
		
		scrollExplorer = new ScrollExplorer(buscarServicio);
		scrollExplorer.resultadosBusqueda(bus);
		panelTarget.setLayout(new BoxLayout(panelTarget, BoxLayout.X_AXIS));
		panelTarget.add(scrollExplorer);
	}

}
