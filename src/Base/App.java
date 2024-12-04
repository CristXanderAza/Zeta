package Base;

import javax.swing.UIManager;

import Persistencia.HashtagRepository;
import Persistencia.IHashtagRepository;
import Persistencia.IMencionesRepository;
import Persistencia.IRespuestaRepository;
import Persistencia.ITemaRepository;
import Persistencia.IUserRepository;
import Persistencia.IZetasRepository;
import Persistencia.LikeComentsRepository;
import Persistencia.LikeZetaRepository;
import Persistencia.MencionesRepository;
import Persistencia.RespuestaRepository;
import Persistencia.TemaRepository;
import Persistencia.UserRepository;
import Persistencia.UserRepositoryFalso;
import Persistencia.ZetaRepository;
import Persistencia.ZetaRepositoryFalso;
import UI.Login;
import UI.Pantalla;
import logica.Usuario;
import logica.Servicios.IRespuestasServicio;
import logica.Servicios.IUserServicio;
import logica.Servicios.IZetasServicio;
import logica.Servicios.RespuestaServicio;
import logica.Servicios.UserSevicio;
import logica.Servicios.ZetaServicio;

public class App {
	
	private static IUserRepository userRepository;
	private static IRespuestaRepository respuestaRespository;
	private static IUserServicio userServicio;
	private static ITemaRepository temaRepository;
	private static IZetasRepository zetaRepository;
	private static IMencionesRepository mencionesRepository;
	private static IHashtagRepository hashtagRepository;
	private static IRespuestasServicio respuestaServicio;
	private static LikeComentsRepository likeRespuestasRepo;
	private static IZetasServicio zetaServicio;
	private static LikeZetaRepository likeZetaRepo;
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
    	UserRepository u = new UserRepository();
    	userRepository = u;
    	temaRepository = new TemaRepository();
    	likeZetaRepo = new LikeZetaRepository(u);
    	zetaRepository = new ZetaRepository(userRepository, temaRepository);
    	respuestaRespository = new RespuestaRepository(userRepository,zetaRepository );
    	mencionesRepository = new MencionesRepository();
    	hashtagRepository = new HashtagRepository();
    	likeRespuestasRepo = new LikeComentsRepository(u);
    	
    	userServicio = new UserSevicio(userRepository);
    	zetaServicio = new ZetaServicio(zetaRepository, likeZetaRepo, userRepository, mencionesRepository, hashtagRepository);
    	respuestaServicio = new RespuestaServicio(respuestaRespository, likeRespuestasRepo);
    }
    
    public static void iniciarSesion(Usuario u) {
    	login.dispose();
    	pantalla = new Pantalla(u, zetaServicio, temaRepository, respuestaServicio);
    }
	
	
	
}
