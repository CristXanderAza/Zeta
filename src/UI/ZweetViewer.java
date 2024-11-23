package UI;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import UI.PublicacionesComponent.ZetaImagenView;
import UI.PublicacionesComponent.ZweetBasicView;
import logica.Usuario;
import logica.Zeta;

public class ZweetViewer extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel zweetsPanel;
    private List<Zeta> zetas;
    private static Usuario placeHolder = new Usuario(0, "Admin", "Admin",  "Admin",  "Admin");

    /**
     * Create the panel.
     */
    public ZweetViewer() {
        // Establece el layout principal
    	zetas = new ArrayList<Zeta>();
    	agregarPlaceHolders();
        initalize();
    }
    
    public void agregarPlaceHolders() {
        for (int i = 0; i < 10; i++) {
            Zeta z = new Zeta(placeHolder,
            		"Este es un ejemplo de contenido largo que automáticamente<br>se ajustará al ancho del área y saltará de línea.", new Date());
            zetas.add(z);
        }
    }
    public void agregarZeta(Zeta z) {
    	zetas.add(z);
    	recargar();
    }
    
    public void recargar() {
    	zweetsPanel.removeAll();
    	agregarZetasAlPanel();
    }
    
    public void agregarZetasAlPanel() {
    	
    	zweetsPanel.add(new ZetaImagenView());
    	for(int i = zetas.size() - 1; i >= 0; i-- ) {
    		Zeta z = zetas.get(i);
    		//System.out.println(z.getBody());
    		ZweetBasicView zv = new ZweetBasicView(z);
    		zweetsPanel.add(zv);
    	}
    }
    
    
    private void initalize() {
        // Establece el layout principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Panel que contiene los tweets
        zweetsPanel = new JPanel();
        zweetsPanel.setLayout(new BoxLayout(zweetsPanel, BoxLayout.Y_AXIS)); // Cambia a BoxLayout para disposición vertical

        // Añade los componentes de tweets al panel
        for (int i = 0; i < 10; i++) {
            ZweetBasicView z = new ZweetBasicView();
            zweetsPanel.add(z);
        }

        // Crea el JScrollPane y añade el zweetsPanel
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Sin scroll horizontal
        scrollPane.setViewportView(zweetsPanel); // Añade zweetsPanel al viewport del scrollPane

        // Añade el JScrollPane al panel principal
        add(scrollPane);
        
    }
}
