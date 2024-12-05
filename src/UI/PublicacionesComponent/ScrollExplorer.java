package UI.PublicacionesComponent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.border.SoftBevelBorder;

import logica.Busqueda;
import logica.Servicios.BusquedaServicio;

import javax.swing.border.BevelBorder;

public class ScrollExplorer extends JPanel {

    private static final long serialVersionUID = 1L;
    private BusquedaServicio busquedaServ;
    JPanel contentPanel;

    public ScrollExplorer(BusquedaServicio busquedaServ) {
    	this.busquedaServ = busquedaServ;
        setLayout(new BorderLayout());
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        contentPanel.setLayout(new BorderLayout()); 
        
        //TargetExplorer targetExplorer = new TargetExplorer();
        contentPanel.setLayout(new GridLayout(0, 1, 10, 10)); 
       /* contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        contentPanel.add(new TargetExplorer());
        */
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void resultadosBusqueda(List<Busqueda> resBus) {
    	contentPanel.removeAll();
    	for (Busqueda busqueda : resBus) {
    		TargetExplorer t = new TargetExplorer(busqueda, this);
    		contentPanel.add(t);
		}
    	
    }
    
    public void verDetalles(Busqueda b) {
    	busquedaServ.mostrarDetalles(b);
    }
}
