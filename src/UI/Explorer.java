package UI;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import UI.PublicacionesComponent.ScrollExplorer;
import logica.Busqueda;
import logica.Servicios.BusquedaServicio;

import javax.swing.border.BevelBorder;

public class Explorer extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldBuscar;
	private BusquedaServicio buscarServicio;
	private ScrollExplorer scrollExplorer ;
	private  BusquedaServicio busquedaServ;

	public Explorer(BusquedaServicio busquedaServ) {
		this.buscarServicio =  busquedaServ;
		setLayout(new BorderLayout());

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		add(panel_1, BorderLayout.EAST);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Perfil", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		panel_1.add(panel_6);

		JLabel lblUserName = new JLabel("Usuario");
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUserName.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_6.add(lblUserName);

		JPanel panel_7 = new JPanel();
		panel_7.setMaximumSize(new Dimension(200, 40));
		panel_6.add(panel_7);

		JButton btnEditPerfil = new JButton("Editar");
		btnEditPerfil.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_7.add(btnEditPerfil);

		JButton btnClosePerfil = new JButton("Cerrar");
		btnClosePerfil.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_7.add(btnClosePerfil);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Tendencias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		panel_1.add(panel_8);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_10.setPreferredSize(new Dimension(140, 60));
		panel_10.setMaximumSize(new Dimension(140, 60));
		panel_8.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
		panel_10.add(panel_11);

		JLabel lblNewLabel = new JLabel("Tendencia 1");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_11.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tendencia 2");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_11.add(lblNewLabel_1);

		JButton btnNewButtonVer = new JButton("Ver");
		btnNewButtonVer.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_10.add(btnNewButtonVer);

		JPanel panel_10_1 = new JPanel();
		panel_10_1.setPreferredSize(new Dimension(140, 60));
		panel_10_1.setMaximumSize(new Dimension(140, 60));
		panel_10_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.add(panel_10_1);

		JPanel panel_11_1 = new JPanel();
		panel_11_1.setLayout(new BoxLayout(panel_11_1, BoxLayout.Y_AXIS));
		panel_10_1.add(panel_11_1);

		JLabel lblNewLabel_2 = new JLabel("Tendencia 3");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_11_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Tendencia 4");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_11_1.add(lblNewLabel_1_1);

		JButton btnNewButtonVer_1 = new JButton("Ver");
		btnNewButtonVer_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_10_1.add(btnNewButtonVer_1);

		JPanel panel_10_1_1 = new JPanel();
		panel_10_1_1.setPreferredSize(new Dimension(140, 60));
		panel_10_1_1.setMaximumSize(new Dimension(140, 60));
		panel_10_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.add(panel_10_1_1);

		JPanel panel_11_1_1 = new JPanel();
		panel_10_1_1.add(panel_11_1_1);
		panel_11_1_1.setLayout(new BoxLayout(panel_11_1_1, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_2_1 = new JLabel("Tendencia 5");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_11_1_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tendencia 6");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_11_1_1.add(lblNewLabel_1_1_1);

		JButton btnNewButtonVer_1_1 = new JButton("Ver");
		btnNewButtonVer_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_10_1_1.add(btnNewButtonVer_1_1);

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		add(panel, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_3, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.add(panel_2);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textFieldBuscar.setColumns(50);
		panel_2.add(textFieldBuscar);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(e -> buscar(textFieldBuscar.getText()));
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_3.add(btnSearch);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		scrollExplorer = new ScrollExplorer(busquedaServ);
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout());
		panel_5.add(scrollExplorer);
	}
	
	public void buscar(String s) {
		
		List<Busqueda> res = buscarServicio.buscar(s);
		scrollExplorer.resultadosBusqueda(res);
	}
}
