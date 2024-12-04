package logica.Servicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Persistencia.IHashtagRepository;
import Persistencia.ILikeRepository;
import Persistencia.IMencionesRepository;
import Persistencia.IUserRepository;
import Persistencia.IZetasRepository;
import logica.Hashtag;
import logica.LikeInteraccion;
import logica.ListUtil;
import logica.Usuario;
import logica.Zeta;
import logica.ZetaInsertDTO;

public class ZetaServicio implements IZetasServicio {

	private IZetasRepository zetaRepository;
	private ILikeRepository likeReposiory;
	private IUserRepository usuarioRepository;
	private IMencionesRepository mencionesRepository;
	private IHashtagRepository hashtagRepository;
	
	public ZetaServicio(IZetasRepository zRepo, ILikeRepository like,IUserRepository usuarioRepository, IMencionesRepository mencionesRepository, IHashtagRepository hashtagRepo) {
		zetaRepository = zRepo;
		likeReposiory = like;
		this.usuarioRepository = usuarioRepository;
		this.mencionesRepository = mencionesRepository;
		hashtagRepository = hashtagRepo;
	}


	@Override
	public Zeta getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zeta> getAll() {
		// TODO Auto-generated method stub
		return zetaRepository.getAll();
	}
	@Override
	public Zeta agregarZeta(ZetaInsertDTO z) {
		// TODO Auto-generated method stub
		Zeta zt = new Zeta(z.getUsuario(), z.getBody(), new Date());
		zt.setTema(z.getTema());
		if(!z.getImageReference().isBlank()) {
			int imageID = zetaRepository.agregarImagen(z.getImageReference());
			zt.setImageID(imageID);
			zt.setImageReference(z.getImageReference());
		}
		zetaRepository.agregarZeta(zt);
		
		//extraer menciones
		List<String> menciones = extraerMenciones(z.getBody());
		List<String> hashtagsTxt = extraerHashtags(z.getBody());
		
		//mostrarMencionesYHashtags(menciones, hashtags);
		//Obtener Usuarios y Hashtags:
		List<Usuario> usuarios = obtenerUsuariosMencionados(menciones);
		List<Hashtag> hashtags = obtenerHashtagsMencionados(hashtagsTxt);
		 
		 
	    //Mencionar:
		for (Usuario usuario : usuarios) {
			mencionesRepository.agregarMencion(usuario.getId(), zt.getId());
		}
		
		//Hashtags
		for (Hashtag hashtag : hashtags) {
			hashtagRepository.agregarZetaAHashtag(zt.getId(), hashtag.getID());
		}
		
		return zt;
	}
	
	
	private List<Usuario> obtenerUsuariosMencionados(List<String> usernames){
		List<Usuario> res = new ArrayList<Usuario>();
		for (String username : usernames) {
			Usuario u = usuarioRepository.getByUsername(username);
			if(u != null) {
				res.add(u);
			}
		}	
		return res;
	}
	
	
	private List<Hashtag> obtenerHashtagsMencionados(List<String> hashtagTxt){
		List<Hashtag> res = new ArrayList<Hashtag>();
		for (String hash : hashtagTxt) {
			Hashtag u = hashtagRepository.obtenerPorNombre(hash);
			if(u != null) {
				res.add(u);
			}
			else {
				Hashtag h = new Hashtag(hash);
				hashtagRepository.agregarHashtag(h);
				res.add(h);
			}
		}	
		return res;
	}
	
	/*
	private void mostrarMencionesYHashtags(List<String> menciones,List<String> hashtag ) {
		System.out.println("Menciones:");
		for (String string : menciones) {
			System.out.println("	" + string);
		}
		System.out.println("Hashtags:");
		for (String string : hashtag) {
			System.out.println("	" + string);
		}
	}
	*/
	/*Notas de Cristopher:
	 * Para el repositorio de los Zetas es necesario tres metodos relacionados a Likes
	 * -Uno para confirmar si el usuario actual le ha dado like
	 * - otro para insertar el like por parte del usuario
	 *  - y otro para quitar el like
	 */
	
	
	@Override
	public void darLike(Zeta z, Usuario u) {
		LikeInteraccion li= z.darLike(u);
		likeReposiory.AddLike(u.getId(), z.getId());
		zetaRepository.darLike(li);
	}
	
	@Override
	public void quitarLike(Zeta z, Usuario u) {
		z.quitarLike(u);
		likeReposiory.DeleteLike(u.getId(), z.getId());
		System.out.println("Se quito un like");
		zetaRepository.quitarLike(u, z);
	}
	
	@Override
	public List<Zeta> getByUserInTimeLapse(Usuario u, Date inicio, Date finall) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Zeta> getZetaDeSeguidos(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Zeta z) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Zeta z) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Zeta rezetear(Zeta padre, ZetaInsertDTO dto) {
		// TODO Auto-generated method stub
		Zeta z = padre.rezetear(dto.getUsuario(), dto.getBody(), new Date());
		zetaRepository.agregarZeta(z);
		return z;
	}
	
	
    // Método para extraer menciones
    public static List<String> extraerMenciones(String tweet) {
        List<String> menciones = new ArrayList<>();
        // Expresión regular para detectar menciones
        Pattern patron = Pattern.compile("@(\\w+)");
        Matcher matcher = patron.matcher(tweet);

        while (matcher.find()) {
            menciones.add(matcher.group(1)); // Captura la palabra después de "@"
        }
        return menciones;
    }

    // Método para extraer hashtags
    public static List<String> extraerHashtags(String tweet) {
        List<String> hashtags = new ArrayList<>();
        // Expresión regular para detectar hashtags
        Pattern patron = Pattern.compile("#(\\w+)");
        Matcher matcher = patron.matcher(tweet);

        while (matcher.find()) {
            hashtags.add(matcher.group(1)); // Captura la palabra después de "#"
        }
        return hashtags;
    }


	@Override
	public List<Zeta> obtenerZetasDeSeguidos(Usuario u) {
		// TODO Auto-generated method stub
		//List<Zeta> zetasSeguidos = zetaRepository.obtenerPorUsuariosSeguidos(u.getId());
		List<Zeta> zetasTemas = zetaRepository.obtenerPorTemaSeguidos(u.getId());
		
        // Definir el comparador para ordenar por fecha
        //Comparator<Zeta> comparadorPorFecha = Comparator.comparing(Zeta :: getFechaPublicacion);
        //List<Zeta> listaOrdenada = ListUtil.combinarYOrdenarPorFecha(zetasSeguidos, zetasTemas, comparadorPorFecha);
		
		return zetasTemas;
	}
	
	@Override
	public List<Zeta> obtenerPorHashtagId( int idHashtag){
		return zetaRepository.obtenerPorHastag(idHashtag);
	}

}
