package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import java.awt.Panel;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Persistencia.ITemaRepository;
import Persistencia.IZetasRepository;
import logica.Usuario;
import logica.Servicios.BusquedaServicio;
import logica.Servicios.IRespuestasServicio;
import logica.Servicios.IZetasServicio;

import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;

public class Pantalla {

	private JFrame frmZeta;
	private Usuario usuarioActual;
	private IZetasServicio zetaServicio;
	private ITemaRepository temaRepositorio;
	private IRespuestasServicio respuestaServicio;
	private JPanel ActualView;
	private JPanel lastView;
	private BusquedaServicio busquedaServicio;
	private IZetasRepository zetaRepo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            try {
	                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	            } catch (Exception ex) {
	                // Manejo de excepción
	            }
	        }
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frmZeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize(null);
	}
	
	public Pantalla(Usuario u, IZetasServicio zs, ITemaRepository temaRepositorio, IRespuestasServicio respuestaServicio, BusquedaServicio bus, 
			IZetasRepository z) {
		this.usuarioActual = u;
		Usuario.setActual(u);
		this.temaRepositorio = temaRepositorio;
		this.zetaServicio = zs;
		this.respuestaServicio = respuestaServicio;
		this.busquedaServicio = bus;
		this.zetaRepo = z;
		initialize(u);
		frmZeta.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario user) {
		frmZeta = new JFrame();
		frmZeta.setTitle("Zeta");
		frmZeta.setBounds(100, 100, 1034, 509);
		frmZeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmZeta.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Zeta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.GRAY);
		panel_7.setBorder(new TitledBorder(null, "Menus", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.add(panel_7);
		
		Panel panel_2 = new Panel();
		panel_7.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		ButtonGroup bgroup = new ButtonGroup();
		JRadioButton rdbtnHome = new JRadioButton("Home");
		rdbtnHome.addActionListener(e -> actualizarVista(new HomePanel(user, zetaServicio, temaRepositorio, respuestaServicio)));
		bgroup.add(rdbtnHome);
		rdbtnHome.setSelected(true);
		rdbtnHome.setForeground(Color.WHITE);
		rdbtnHome.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnHome);
		
		JRadioButton rdbtnExplorar = new JRadioButton("Explorar         .");
		rdbtnExplorar.addActionListener(e -> actualizarVista(new Explorer(busquedaServicio)));
		bgroup.add(rdbtnExplorar);
		rdbtnExplorar.setForeground(Color.WHITE);
		rdbtnExplorar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnExplorar);
		
		JRadioButton rdbtnNotif = new JRadioButton("Notificaciones");
		rdbtnNotif.addActionListener(e -> actualizarVista(new NotificationsPanel()));
		bgroup.add(rdbtnNotif);
		rdbtnNotif.setForeground(Color.WHITE);
		rdbtnNotif.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnNotif);
		
		JRadioButton rdbtnMensajes = new JRadioButton("Mensajes");
		bgroup.add(rdbtnMensajes);
		rdbtnMensajes.setForeground(Color.WHITE);
		rdbtnMensajes.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnMensajes);
		
		JRadioButton rdbtnPerfil = new JRadioButton("Perfil");
		rdbtnPerfil.addActionListener(e -> actualizarVista(new Perfil(zetaRepo, zetaServicio, respuestaServicio, busquedaServicio)));
		bgroup.add(rdbtnPerfil);
		rdbtnPerfil.setForeground(Color.WHITE);
		rdbtnPerfil.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnPerfil);
		
		ActualView = new JPanel();
		JPanel v = new HomePanel(user, zetaServicio, temaRepositorio,respuestaServicio);
		//ActualView.add(v);
		lastView = v;
		actualizarVista(v); 
	}
	
	private void actualizarVista(JPanel vw) {
	    System.out.println("Cambio Vista");
	    // Eliminar la última vista del contenedor
	    frmZeta.getContentPane().remove(lastView);

	    // Agregar la nueva vista en la posición CENTER
	    frmZeta.getContentPane().add(vw, BorderLayout.CENTER);

	    // Actualizar la referencia a la última vista
	    lastView = vw;

	    // Revalidar y repintar para actualizar la interfaz gráfica
	    frmZeta.getContentPane().revalidate();
	    frmZeta.getContentPane().repaint();
	
	}
}
