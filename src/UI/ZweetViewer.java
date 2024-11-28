package UI;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import UI.PublicacionesComponent.RespuestaWindow;
import UI.PublicacionesComponent.RezetaBasicView;
import UI.PublicacionesComponent.ZetaImagenView;
import UI.PublicacionesComponent.ZweetBasicView;
import logica.Respuesta;
import logica.Usuario;
import logica.Zeta;

import logica.Servicios.IRespuestasServicio;
import logica.Servicios.IZetasServicio;

public class ZweetViewer extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel zweetsPanel;
    private List<Zeta> zetas;
    private Usuario actualUsuario;
	private IZetasServicio zetaServicio;
	private IRespuestasServicio respuestaServicio;
    private static Usuario placeHolder = new Usuario(0, "Admin", "Admin",  "Admin",  "Admin", true);
    private Boolean activarBotones;

    /**
     * Create the panel.
     */
    public ZweetViewer() {
        // Establece el layout principal
    	zetas = new ArrayList<Zeta>();
    	this.activarBotones = true;
    	agregarPlaceHolders();
        initalize();
    }
    
    public ZweetViewer(List<Zeta> zetas) {
        // Establece el layout principal
    	this.zetas = zetas; 
    	this.activarBotones = true;
        initalize();
    }
    
    public ZweetViewer(Zeta zeta, Boolean activarBotones) {
        // Establece el layout principal
    	zetas = new ArrayList<Zeta>();
    	zetas.add(zeta);
    	this.activarBotones = activarBotones;
        initalize();
    }
    
    public ZweetViewer(Usuario actualUsuario, IZetasServicio zetaServicio) {
        // Establece el layout principal
    	this.actualUsuario = actualUsuario;
    	this.activarBotones = true;
    	this.zetaServicio = zetaServicio;
    	
    	zetas = new ArrayList<Zeta>();
    	agregarPlaceHolders();
        initalize();
    }
    
    public ZweetViewer(Usuario actualUsuario, IZetasServicio zetaServicio,List<Zeta> zetas) {
        // Establece el layout principal
       	this.actualUsuario = actualUsuario;
       	this.activarBotones = true;
    	this.zetaServicio = zetaServicio;
    	
    	this.zetas = zetas;
        initalize();
    }
    
    
    public ZweetViewer(Usuario actualUsuario, IRespuestasServicio respServ) {
        // Establece el layout principal
    	this.actualUsuario = actualUsuario;
    	this.activarBotones = true;
    	this.respuestaServicio = respServ;
    	
    	zetas = new ArrayList<Zeta>();
    	agregarPlaceHolders();
        initalize();
    }
    
    public ZweetViewer(Usuario actualUsuario, IRespuestasServicio respServ,List<Zeta> zetas) {
        // Establece el layout principal
       	this.actualUsuario = actualUsuario;
       	this.activarBotones = true;
       	this.respuestaServicio = respServ;
    	
    	this.zetas = zetas;
        initalize();
    }
    
    
    public ZweetViewer(Usuario actualUsuario, IZetasServicio zetaServicio, Zeta zeta) {
        // Establece el layout principal
       	this.actualUsuario = actualUsuario;
    	this.zetaServicio = zetaServicio;
    	this.activarBotones = true;
    	zetas = new ArrayList<Zeta>();
    	zetas.add(zeta);
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
    	
    	//zweetsPanel.add(new ZetaImagenView());
    	for(int i = zetas.size() - 1; i >= 0; i-- ) {
    		Zeta z = zetas.get(i);
    		//System.out.println(z.getBody());
    		if(z.getParent() != null) {
    			RezetaBasicView rzv = new RezetaBasicView(z, this, activarBotones);
    			zweetsPanel.add(rzv);
    		}
    		else if(!z.getImageReference().isBlank()) {
    			ZetaImagenView ziv = new ZetaImagenView(z, this, activarBotones);
    			System.out.println("Imagen insertada");
    			zweetsPanel.add(ziv);
    		}
    		else {
        		ZweetBasicView zv = new ZweetBasicView(z, this, activarBotones);
        		zweetsPanel.add(zv);
    		}

    	}
    }
    
    
    private void initalize() {
        // Establece el layout principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Panel que contiene los tweets
        zweetsPanel = new JPanel();
        zweetsPanel.setLayout(new BoxLayout(zweetsPanel, BoxLayout.Y_AXIS)); // Cambia a BoxLayout para disposición vertical
        
        //agregarPlaceHolders();
        agregarZetasAlPanel();
        
        // Añade los componentes de tweets al panel
       /* for (int i = 0; i < 10; i++) {
            ZweetBasicView z = new ZweetBasicView(this);
            zweetsPanel.add(z);
        }
		*/
        // Crea el JScrollPane y añade el zweetsPanel
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Sin scroll horizontal
        scrollPane.setViewportView(zweetsPanel); // Añade zweetsPanel al viewport del scrollPane

        // Añade el JScrollPane al panel principal
        add(scrollPane);
        
    }
    
    public void Rezetear(Zeta z) {
    	System.out.println("Rezeta 2");
    	new RezetearWindow(z,zetaServicio, actualUsuario, this);
    }
    
    public void darLike(Zeta z) {
    	zetaServicio.darLike(z, actualUsuario);
    }
    
    public void darLikeResp(Respuesta r) {
    	respuestaServicio.darLike(r, actualUsuario);
    }
    
    public void quitarLike(Zeta z) {
    	zetaServicio.quitarLike(z, actualUsuario);
    }
    
    public void quitarLikeResp(Respuesta z) {
    	respuestaServicio.quitarLike(z, actualUsuario);
    }
    
    public void Responder(Zeta z) {
    	RespuestaWindow rw = new RespuestaWindow();
    	
    }
    
}
