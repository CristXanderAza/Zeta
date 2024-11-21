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
import java.awt.Component;
import java.awt.Panel;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import logica.Usuario;
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

	private JFrame frame;
	private Usuario usuarioActual;
	private IZetasServicio zetaServicio;


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
	public Pantalla() {
		initialize(null);
	}
	
	public Pantalla(Usuario u, IZetasServicio zs) {
		this.usuarioActual = u;
		this.zetaServicio = zs;
		initialize(u);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1034, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.WEST);
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
		
		JRadioButton rdbtnHome = new JRadioButton("Home");
		rdbtnHome.setSelected(true);
		rdbtnHome.setForeground(Color.WHITE);
		rdbtnHome.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnHome);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Explorar         .");
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Notificaciones");
		rdbtnNewRadioButton_1_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("Mensajes");
		rdbtnNewRadioButton_1_2.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_2_1 = new JRadioButton("Perfil");
		rdbtnNewRadioButton_1_2_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_2.add(rdbtnNewRadioButton_1_2_1);
		
		JPanel ActualView = new JPanel();
		ActualView.add(new HomePanel(user));
		frame.getContentPane().add(new HomePanel(user), BorderLayout.CENTER);
	}
}
