package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import Base.App;
import logica.Usuario;
import logica.Servicios.IUserServicio;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmLogin;
	private JTextField txtUser;
	private JPasswordField txtContrasenia;
	
	private IUserServicio userServicio;

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
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		frmLogin.setVisible(true);
		//frame.setUndecorated(true);

	}
	
	public Login(IUserServicio userServicio) {
		super();
		this.userServicio = userServicio;
		initialize();
		frmLogin.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 452, 312);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmLogin.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Zeta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		frmLogin.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_3.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario        ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.add(panel_2);
		
		txtUser = new JTextField();
		txtUser.setBackground(Color.LIGHT_GRAY);
		panel_2.add(txtUser);
		txtUser.setColumns(10);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.GRAY);
		panel_3.add(panel_4_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_4_1.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBackground(Color.GRAY);
		panel_4_1.add(panel_2_1);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBackground(Color.LIGHT_GRAY);
		txtContrasenia.setColumns(10);
		panel_2_1.add(txtContrasenia);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnNewButton.addActionListener(e -> inciarSesion());
		panel_3.add(btnNewButton);
		
		JButton btnRegistrar = new JButton("Registrarte");
		btnRegistrar.addActionListener(e -> App.registrar());
		btnRegistrar.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		btnRegistrar.setBackground(Color.GRAY);
		frmLogin.getContentPane().add(btnRegistrar, BorderLayout.SOUTH);
	}
	
	private void inciarSesion() {
		String user = txtUser.getText();
		String contra = txtContrasenia.getText();
		
		System.out.println(contra);
		
		Usuario u = userServicio.iniciarSesion(user, contra);
		if(u != null) {
			App.iniciarSesion(u);
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos", "Inicio de sesion fallido", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
	public void dispose() {
		
		frmLogin.dispose();
	}

}
