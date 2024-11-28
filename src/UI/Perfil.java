package UI;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.border.SoftBevelBorder;

import UI.PublicacionesComponent.ScrollPerfil;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class Perfil extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Perfil() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		panel.add(panel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);

		JLabel lblNewLabelUsuario = new JLabel("Usuario");
		lblNewLabelUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panel_7.add(lblNewLabelUsuario);

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);

		JButton btnNewButton_1 = new JButton("New button");
		panel_8.add(btnNewButton_1);

		JButton btnNewButton = new JButton("New button");
		panel_8.add(btnNewButton);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.add(panel_9);

		JLabel lblNewLabelSeguidores = new JLabel("Seguidores :: 100");
		lblNewLabelSeguidores.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_9.add(lblNewLabelSeguidores);

		ScrollPerfil scrollPerfil = new ScrollPerfil();
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(scrollPerfil);

		panel_2.setPreferredSize(new Dimension(400, panel_2.getPreferredSize().height));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.NORTH);

		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "Tendencia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS)); 
		panel_12.add(panel_13);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_13.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.X_AXIS)); 

		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.Y_AXIS));

		JLabel lblNewLabel = new JLabel("Tendencia 1");
		panel_15.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tendencia 2");
		panel_15.add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("New button");
		panel_14.add(btnNewButton_2);

		JPanel panel_14_1 = new JPanel();
		panel_14_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_13.add(panel_14_1);
		panel_14_1.setLayout(new BoxLayout(panel_14_1, BoxLayout.X_AXIS));

		JPanel panel_15_1 = new JPanel();
		panel_14_1.add(panel_15_1);
		panel_15_1.setLayout(new BoxLayout(panel_15_1, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_2 = new JLabel("Tendencia 3");
		panel_15_1.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Tendencia 4");
		panel_15_1.add(lblNewLabel_1_1);

		JButton btnNewButton_2_1 = new JButton("New button");
		panel_14_1.add(btnNewButton_2_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_5, BorderLayout.NORTH);

		JLabel lblNewLabelPerfil = new JLabel("Perfil");
		lblNewLabelPerfil.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel_5.add(lblNewLabelPerfil);
	}
}
