package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;
import logica.Servicios.IZetasServicio;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class RezetearWindow {

	private JFrame frmRezetear;
	private ZweetViewer zv;
	private Zeta zetaARezetear;
	private ZweetViewer root;
	private Usuario usuarioActual;
	private IZetasServicio zetaServicio;
	private JTextArea txtZeta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezetearWindow window = new RezetearWindow();
					window.frmRezetear.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RezetearWindow() {
		initialize(Zeta.placeholder());
		
	}
	
	public RezetearWindow(Zeta zetaARezetear, IZetasServicio zs, Usuario u , ZweetViewer root) {
		super();
		this.zetaARezetear = zetaARezetear;
		this.zetaServicio = zs;
		this.root = root;
		this.usuarioActual = u;
		initialize(zetaARezetear);
		frmRezetear.setVisible(true);
	}
	
	public RezetearWindow(Zeta zetaARezetear, IZetasServicio zs, Usuario u) {
		super();
		this.zetaARezetear = zetaARezetear;
		this.zetaServicio = zs;
		this.root = null;
		this.usuarioActual = u;
		initialize(zetaARezetear);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Zeta z) {
		frmRezetear = new JFrame();
		frmRezetear.setTitle("Rezetear");
		frmRezetear.setBounds(100, 100, 675, 426);
		frmRezetear.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRezetear.getContentPane().setLayout(new BoxLayout(frmRezetear.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmRezetear.getContentPane().add(panel_6);
		
		txtZeta = new JTextArea();
		txtZeta.setText("");
		txtZeta.setBounds(14, 18, 473, 85);
		
		panel_6.add(txtZeta);
		
		JButton btnRezetear = new JButton("Rezetear");
		btnRezetear.addActionListener(e -> Rezetear());
		btnRezetear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnRezetear.setBounds(499, 18, 139, 103);
		panel_6.add(btnRezetear);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(393, 85, 82, 40);
		panel_6.add(panel_4);
		
		JLabel lblCaracteres = new JLabel("0/280");
		lblCaracteres.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblCaracteres.setBounds(14, 18, 62, 16);
		panel_4.add(lblCaracteres);
		
		JPanel panel = new JPanel();
		frmRezetear.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		zv = new ZweetViewer(z, false);
		zv.setPreferredSize(new Dimension(20, 80));
		panel.add(zv);
		
		txtZeta.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // No se usa para cambios simples en JTextArea.
            	
            	
            }
            private void updateCharacterCount() {
                int carac = txtZeta.getText().length();
                lblCaracteres.setText(carac + "/280");

                if (carac > 280) {
                	btnRezetear.setEnabled(false);
                    lblCaracteres.setForeground(Color.RED);
                } else {
                	btnRezetear.setEnabled(true);
                    lblCaracteres.setForeground(Color.BLACK);
                }
            }

            private void onChange() {
                int carac = txtZeta.getText().length();
                lblCaracteres.setText(carac + "/280");

                if (carac > 280) {
                	btnRezetear.setEnabled(false);
                    lblCaracteres.setForeground(Color.RED);
                } else {
                	btnRezetear.setEnabled(true);
                    lblCaracteres.setForeground(Color.BLACK);
                }
            }
        });
	}
	
	private void Rezetear() {
		String body = txtZeta.getText();
		Date d = new Date();
		Zeta z = zetaServicio.rezetear(zetaARezetear, new ZetaInsertDTO(body,"", usuarioActual, zetaARezetear.getTema()));
		if(root != null)
		{
			root.agregarZeta(z);
		}
		frmRezetear.dispose();
	}

}
