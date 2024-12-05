package Base;

import java.util.List;

import javax.swing.UIManager;

import Persistencia.BusquedaRepository;
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
import Persistencia.ZetaRepository;
import UI.Login;
import UI.Pantalla;
import UI.ProfileViewPanel;
import UI.ResgistrarView;
import UI.ScrollZetaViewer;
import logica.Hashtag;
import logica.Usuario;
import logica.Zeta;
import logica.Servicios.BusquedaServicio;
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
	private static BusquedaServicio busquedaServicio;
	private static BusquedaRepository busquedaRepo;
	
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
    	busquedaRepo = new BusquedaRepository();
    	
    	userServicio = new UserSevicio(userRepository, temaRepository);
    	busquedaServicio = new BusquedaServicio(busquedaRepo);
    	zetaServicio = new ZetaServicio(zetaRepository, likeZetaRepo, userRepository, mencionesRepository, hashtagRepository);
    	respuestaServicio = new RespuestaServicio(respuestaRespository, likeRespuestasRepo);
    }
    
    public static void iniciarSesion(Usuario u) {
    	login.dispose();
    	pantalla = new Pantalla(u, zetaServicio, temaRepository, respuestaServicio, busquedaServicio, zetaRepository);
    }
    
    public static void visualizarZetasPorHashtag(int hashtagID) {
    	Hashtag h = hashtagRepository.obtenerPorId(hashtagID);
    	ScrollZetaViewer sv = new ScrollZetaViewer(zetaServicio.obtenerPorHashtagId(hashtagID), h.getNombre(), zetaServicio, respuestaServicio);
    }
    
    public static void visualizarPerfil(int idUsuario) {
    	Usuario u = Usuario.getActual();
    	Usuario aMostrar = userRepository.getByID(idUsuario);
    	Boolean b = u.loEstoySiguiendo(idUsuario);
    	int seguidores = UserRepository.CantidadSeguidores(idUsuario);
    	List<Zeta> zetas = zetaRepository.obtenerPorUsuario(aMostrar);
    	ProfileViewPanel pro = new ProfileViewPanel(zetas, aMostrar.getNombre(), seguidores, zetaServicio, respuestaServicio,
    			userServicio, b, aMostrar.getId());
    	
    }
    
    public static void registrar() {
    	ResgistrarView rv = new ResgistrarView(userServicio, temaRepository);
    }
	
	
	
}
