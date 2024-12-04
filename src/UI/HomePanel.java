package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Persistencia.ITemaRepository;
import logica.Tema;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;
import logica.Servicios.IRespuestasServicio;
import logica.Servicios.IZetasServicio;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.util.Date;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JComboBox;

public class HomePanel extends JPanel implements ChangeListener{

	private static final long serialVersionUID = 1L;
	private JTextArea txtZeta;
	private JLabel lblCaracteres;
	private JButton btnPublicar;
	private Usuario actualUsuario;
	private ZweetViewer zv;
	private JComboBox<Tema> cmbTema;
	private ITemaRepository temaRepositorio;
	private IZetasServicio zetaServicio;
	private IRespuestasServicio respuestaServicio;
	private String imagenRuta;
	private JButton btnImagen ;
	
	/**
	 * Create the panel.
	 */
	public HomePanel(Usuario u, IZetasServicio zetaServicio, ITemaRepository temaRepo, IRespuestasServicio respuestaServicio ) {
		imagenRuta = "";
		setLayout(new BorderLayout(0, 0));
		actualUsuario = u;
		this.zetaServicio = zetaServicio;
		this.temaRepositorio = temaRepo;
		this.respuestaServicio =  respuestaServicio;
		JPanel panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Perfil", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		JLabel lblUserName = new JLabel(u.getUsername());
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblUserName.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_9.add(lblUserName);
		
		JPanel panel_3 = new JPanel();
		panel_9.add(panel_3);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_3.add(btnNewButton_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Tendencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_41 = new JPanel();
		panel_41.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.add(panel_41);
		
		JPanel panel_8 = new JPanel();
		panel_41.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_8.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		panel_8.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("ver");
		btnNewButton_3.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_41.add(btnNewButton_3);
		
		JPanel panel_41_1 = new JPanel();
		panel_41_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.add(panel_41_1);
		
		JPanel panel_8_1 = new JPanel();
		panel_41_1.add(panel_8_1);
		panel_8_1.setLayout(new BoxLayout(panel_8_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_8_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		panel_8_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_3_1 = new JButton("ver");
		btnNewButton_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_41_1.add(btnNewButton_3_1);
		
		JPanel panel_41_1_1 = new JPanel();
		panel_41_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.add(panel_41_1_1);
		
		JPanel panel_8_1_1 = new JPanel();
		panel_41_1_1.add(panel_8_1_1);
		panel_8_1_1.setLayout(new BoxLayout(panel_8_1_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_8_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		panel_8_1_1.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_3_1_1 = new JButton("ver");
		btnNewButton_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_41_1_1.add(btnNewButton_3_1_1);
		
		JPanel panel_41_1_1_1 = new JPanel();
		panel_41_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.add(panel_41_1_1_1);
		
		JPanel panel_8_1_1_1 = new JPanel();
		panel_41_1_1_1.add(panel_8_1_1_1);
		panel_8_1_1_1.setLayout(new BoxLayout(panel_8_1_1_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_8_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 8));
		panel_8_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("ver");
		btnNewButton_3_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		panel_41_1_1_1.add(btnNewButton_3_1_1_1);
		
		JPanel panel_4_1 = new JPanel();
		panel.add(panel_4_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel.add(panel_4_1_1);
		
		JPanel panel_4_1_2 = new JPanel();
		panel.add(panel_4_1_2);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.add(panel_6);
		
		 txtZeta = new JTextArea();
		txtZeta.setBounds(14, 18, 473, 85);
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
                    btnPublicar.setEnabled(false);
                    lblCaracteres.setForeground(Color.RED);
                } else {
                    btnPublicar.setEnabled(true);
                    lblCaracteres.setForeground(Color.BLACK);
                }
            }

            private void onChange() {
                int carac = txtZeta.getText().length();
                lblCaracteres.setText(carac + "/280");

                if (carac > 280) {
                    btnPublicar.setEnabled(false);
                    lblCaracteres.setForeground(Color.RED);
                } else {
                    btnPublicar.setEnabled(true);
                    lblCaracteres.setForeground(Color.BLACK);
                }
            }
        });

		panel_6.add(txtZeta);
		
		btnPublicar = new JButton("Publicar");
		btnPublicar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnPublicar.addActionListener(e -> agregarZeta());
		btnPublicar.setBounds(499, 18, 139, 103);
		panel_6.add(btnPublicar);
		
		btnImagen = new JButton("Imagen");
		btnImagen.addActionListener(e -> seleccionarImagen());
		btnImagen.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnImagen.setBounds(14, 104, 92, 17);
		panel_6.add(btnImagen);
		
		JButton btnHilo = new JButton("Hilo");
		btnHilo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnHilo.setBounds(105, 104, 92, 17);
		panel_6.add(btnHilo);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(393, 85, 82, 40);
		panel_6.add(panel_4);
		panel_4.setLayout(null);
		
		 lblCaracteres = new JLabel("0/280");
		lblCaracteres.setBounds(14, 18, 62, 16);
		panel_4.add(lblCaracteres);
		lblCaracteres.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		 cmbTema = new JComboBox<Tema>();
		List<Tema> temas = temaRepositorio.obtenerTodosLosTemas();
		for (Tema tema : temas) {
			cmbTema.addItem(tema);
		}
		cmbTema.setBounds(203, 104, 108, 21);
		panel_6.add(cmbTema);
		
		JPanel panelZweetsView = new JPanel();
		panelZweetsView.add(new ZweetViewer());
		zv = new ZweetViewer(actualUsuario, zetaServicio, zetaServicio.obtenerZetasDeSeguidos(actualUsuario), respuestaServicio);
		zv.setPreferredSize(new Dimension(20, 200));
		panel_5.add(zv);

	}


	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txtZeta)) {
			int carac = txtZeta.getText().length();
			lblCaracteres.setText(carac + "/280");
			if(carac > 280) {
				btnPublicar.setEnabled(false);
				lblCaracteres.setForeground(Color.red);
			}
			else {
				btnPublicar.setEnabled(true);
				lblCaracteres.setForeground(Color.black);
			}
		}
	}
	
	public void agregarZeta() {
		ZetaInsertDTO dto = new ZetaInsertDTO(txtZeta.getText(),(!imagenRuta.isBlank())? imagenRuta : "",actualUsuario, (Tema) cmbTema.getSelectedItem());
		Zeta z = zetaServicio.agregarZeta(dto);
		zv.agregarZeta(z);
		txtZetaSetBlank();
		quitarImagen();
	}
	
	public void txtZetaSetBlank() {
		txtZeta.setText("");
		imagenRuta = "";
	}
	
	public void quitarImagen() {
		imagenRuta ="";
		btnImagen.setForeground(Color.black);
        btnImagen.setText("Imagen");
	}
	
	public void Rezetear(Zeta z) {
		//zv.agregarZeta(z);
		new RezetearWindow(z, zetaServicio, actualUsuario, zv);
	}
	
    public  void seleccionarImagen() {
    	
    	if(imagenRuta.isBlank())
    	{
            // Crear el JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            
            // Configurar un filtro para mostrar solo imágenes
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    // Mostrar directorios y archivos con extensiones válidas
                    return f.isDirectory() || f.getName().toLowerCase().matches(".*\\.(png|jpg|jpeg|gif|bmp)$");
                }

                @Override
                public String getDescription() {
                    return "Imágenes (*.png, *.jpg, *.jpeg, *.gif, *.bmp)";
                }
            });

            // Mostrar el diálogo de selección
            int resultado = fileChooser.showOpenDialog(null);
            
            // Verificar si se seleccionó un archivo
            if (resultado == JFileChooser.APPROVE_OPTION) {
                // Obtener la ruta del archivo seleccionado
                File archivoSeleccionado = fileChooser.getSelectedFile();
                imagenRuta =  archivoSeleccionado.getAbsolutePath();
            } 
            btnImagen.setForeground(Color.red);
            btnImagen.setText("Quitar Imagen");
    	}
    	else {
    		
    		quitarImagen();            
    	}
    }
}
