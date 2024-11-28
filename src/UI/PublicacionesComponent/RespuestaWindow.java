package UI.PublicacionesComponent;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import UI.ZweetViewer;
import logica.Usuario;
import logica.Zeta;

import logica.Servicios.IRespuestasServicio;

import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;

public class RespuestaWindow {

	private JFrame frmResponder;
	private ZweetViewer zv;
	private ZweetViewer zvr;
	private IRespuestasServicio respuestaServicio;
	private Usuario u;
	private Zeta z;

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
					RespuestaWindow window = new RespuestaWindow();
					window.frmResponder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RespuestaWindow() {
		z = Zeta.placeholder();
		initialize();
		frmResponder.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResponder = new JFrame();
		frmResponder.setTitle("Responder");
		frmResponder.setBounds(100, 100, 667, 675);
		frmResponder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResponder.getContentPane().setLayout(new BoxLayout(frmResponder.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frmResponder.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		
		zv = new ZweetViewer(z, false);
		zv.setPreferredSize(new Dimension(20, 80));
		panel.add(zv);
		JPanel panel_1 = new JPanel();
		frmResponder.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(0, 0, 652, 118);
		panel_1.add(panel_6);
		
		JTextArea txtZeta = new JTextArea();
		txtZeta.setText("");
		txtZeta.setBounds(14, 18, 451, 72);
		panel_6.add(txtZeta);
		
		JButton btnResponder = new JButton("Responder");
		btnResponder.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnResponder.setBounds(477, 18, 152, 94);
		panel_6.add(btnResponder);
		
		JButton btnImagen = new JButton("Imagen");
		btnImagen.setEnabled(false);
		btnImagen.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnImagen.setBounds(14, 95, 92, 17);
		panel_6.add(btnImagen);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(376, 72, 82, 40);
		panel_6.add(panel_4);
		
		JLabel lblCaracteres = new JLabel("0/280");
		lblCaracteres.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCaracteres.setBounds(14, 18, 62, 16);
		panel_4.add(lblCaracteres);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		zvr = new ZweetViewer(u, respuestaServicio);
		zvr.setPreferredSize(new Dimension(20, 200));
		panel_2.add(zvr);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmResponder.getContentPane().add(panel_2);
	}
}
