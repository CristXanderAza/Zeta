package UI.PublicacionesComponent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class TargetExplorer extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblDescripcion;
	private JLabel lblUsuario;
	private JButton btnDetalles;

	public TargetExplorer() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		add(panel);

		lblUsuario = new JLabel("Usuario o Hashtag");
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 15));

		lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		btnDetalles = new JButton("Detalles");
		btnDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(lblUsuario);
		panel.add(lblDescripcion);
		panel.add(btnDetalles);
	}
}
