package Base;

import javax.swing.UIManager;

import Persistencia.IUserRepository;
import Persistencia.IZetasRepository;
import Persistencia.UserRepositoryFalso;
import Persistencia.ZetaRepositoryFalso;
import UI.Login;
import UI.Pantalla;
import logica.Usuario;
import logica.Servicios.IUserServicio;
import logica.Servicios.IZetasServicio;
import logica.Servicios.UserSevicio;
import logica.Servicios.ZetaServicio;

public class App {
	
	private static IUserRepository userRepository;
	private static IUserServicio userServicio;
	private static IZetasRepository zetaRepository;
	private static IZetasServicio zetaServicio;
	private static Login login;
	private static Pantalla pantalla;
	
    public static void main(String[] args) {
		 try {
	            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            try {
	                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	            } catch (Exception ex) {
	                // Manejo de excepción
	            }
	        }
    	
    	
    	iniciarDependencias();
    	login = new Login(userServicio);
	}
    
    
    private static void iniciarDependencias() {
    	userRepository = new UserRepositoryFalso();
    	zetaRepository = new ZetaRepositoryFalso();
    	
    	userServicio = new UserSevicio(userRepository);
    	zetaServicio = new ZetaServicio(zetaRepository);
    }
    
    public static void iniciarSesion(Usuario u) {
    	login.dispose();
    	pantalla = new Pantalla(u, zetaServicio);
    }
	
	
	
}
