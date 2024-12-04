package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Persistencia.ITemaRepository;
import Persistencia.IUserRepository;
import logica.Tema;
import logica.Usuario;
import logica.Servicios.IUserServicio;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ResgistrarView {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtUsername;
	private JPasswordField txtContrasenia;
	private JPasswordField txtContraseniaRep;
	private IUserServicio usuarioServicio;
	private ITemaRepository temaRepo;
	private DefaultListModel<Tema> modelo;
	private JList<Tema> temaList;
	private JComboBox<Tema> cmbTema ;
	private Boolean actualizando;
	private Usuario u;

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
					ResgistrarView window = new ResgistrarView();
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
	public ResgistrarView() {
		initialize();
	}
	
	public ResgistrarView(IUserServicio usuarioServicio, ITemaRepository temaRepo) {
		super();
		this.usuarioServicio = usuarioServicio;
		this.actualizando = false;
		this.temaRepo = temaRepo;
	}

	public ResgistrarView(Usuario u, IUserServicio usuarioServicio, ITemaRepository temaRepo) {
		super();
		this.u = u;
		this.actualizando = true;
		this.usuarioServicio = usuarioServicio;
		this.temaRepo = temaRepo;
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 678, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Zeta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JButton btnAgregar = new JButton("Registrarte");
		btnAgregar.addActionListener(e -> crearUsuario());
		btnAgregar.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		btnAgregar.setBackground(Color.GRAY);
		frame.getContentPane().add(btnAgregar, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Nombre", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(416, 30, 222, 60);
		panel_1.add(panel_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(14, 18, 194, 28);
		panel_2.add(txtNombre);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new TitledBorder(null, "Correo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(416, 104, 222, 60);
		panel_1.add(panel_2_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(14, 18, 194, 28);
		panel_2_1.add(txtCorreo);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new TitledBorder(null, "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_2_2.setBackground(Color.GRAY);
		panel_2_2.setBounds(416, 176, 222, 60);
		panel_1.add(panel_2_2);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(14, 18, 194, 28);
		panel_2_2.add(txtUsername);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(416, 243, 226, 60);
		panel_1.add(panel_3);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(14, 18, 198, 28);
		panel_3.add(txtContrasenia);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(null, "Repetir Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_3_1.setBackground(Color.GRAY);
		panel_3_1.setBounds(416, 315, 226, 60);
		panel_1.add(panel_3_1);
		
		txtContraseniaRep = new JPasswordField();
		txtContraseniaRep.setBounds(14, 18, 198, 28);
		panel_3_1.add(txtContraseniaRep);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBorder(new TitledBorder(null, "Temas A Seguir", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_4.setBounds(18, 12, 356, 305);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		modelo = new DefaultListModel<>();
		temaList = new JList<>(modelo);
		temaList.setBounds(14, 18, 328, 273);
		panel_4.add(temaList);
		
		cmbTema =  new JComboBox<Tema>();
		List<Tema> temas = temaRepo.obtenerTodosLosTemas();
		for (Tema tema : temas) {
			cmbTema.addItem(tema);
		}
		cmbTema.setBounds(27, 315, 148, 26);
		panel_1.add(cmbTema);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(e -> anadirTema() );
		btnAnadir.setBounds(187, 314, 86, 28);
		panel_1.add(btnAnadir);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(e -> borrarTema());
		btnRemover.setBounds(280, 314, 86, 28);
		panel_1.add(btnRemover);
	}
	
	private void anadirTema() {
		modelo.addElement((Tema)cmbTema.getSelectedItem());
	}
	
	private List<Tema> obtenerTodosLosObjetos() {
	    List<Tema> objetos = new ArrayList<>();
	    

	    for (int i = 0; i < modelo.getSize(); i++) {
	        objetos.add(modelo.getElementAt(i));
	    }
	    return objetos;
	}
	
	private void borrarTema() {
		modelo.removeElement(temaList.getSelectedValue());
	}
	
	private void crearUsuario() {
		String nombre = txtNombre.getText();
		String usuario = txtUsername.getText();
		String correo = txtCorreo.getText();
		String contrasenia = txtContrasenia.getText();
		if(contrasenia.equals(txtContraseniaRep.getText())) {
			usuarioServicio.CrearNuevoUsuario(nombre, correo, usuario, contrasenia, obtenerTodosLosObjetos());
		}
		
	}
}
