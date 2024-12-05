package UI.PublicacionesComponent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import logica.Busqueda;

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
	private Busqueda bus;
	private ScrollExplorer contenedor;

	public TargetExplorer(Busqueda bu, ScrollExplorer contenedor) {
		super();
		this.bus = bu;
		this.contenedor = contenedor;
		initialize();
	}

	public void  initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		add(panel);

		String pre  = (bus.getTipo().equals("Hashtag"))? "#" : "@";
		lblUsuario = new JLabel(pre +bus.getNombre());
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 15));

		String sub  = (bus.getTipo().equals("Hashtag"))? " zetas" : " seguidores";
		lblDescripcion = new JLabel("" +bus.getCantidad() + sub);
		lblDescripcion.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener(e -> verDetalles());
		btnDetalles.setFont(new Font("Century Gothic", Font.PLAIN, 12));

		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(lblUsuario);
		panel.add(lblDescripcion);
		panel.add(btnDetalles);
	}
	
	private void verDetalles() {
		System.out.println("Se esta ejecutando ver detalles");
        contenedor.verDetalles(bus);
	}
}
