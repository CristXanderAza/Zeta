package UI.PublicacionesComponent;

import UI.ZweetViewer;
import logica.Zeta;
import logica.Servicios.IZetasServicio;

public class CommonZetaViewLogic {
	

	private IZetasServicio zetaServicio;
	private Zeta z;
	private ZweetViewer mainViewer;
	
	public CommonZetaViewLogic(IZetasServicio zetaServicio, Zeta z, ZweetViewer mainViewer) {
		super();
		this.zetaServicio = zetaServicio;
		this.z = z;
		this.mainViewer = mainViewer;
	}
	
	public CommonZetaViewLogic(IZetasServicio zetaServicio, Zeta z) {
		super();
		this.zetaServicio = zetaServicio;
		this.z = z;
		this.mainViewer = null;
	}
	
	
}
