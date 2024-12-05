package logica.Servicios;

import Persistencia.BusquedaRepository;
import Persistencia.HashtagRepository;
import Persistencia.UserRepository;
import java.util.List;

import Base.App;
import logica.Busqueda;
import logica.Hashtag;
import logica.Servicios.ZetaServicio;
import logica.Usuario;
import logica.Zeta;



public class BusquedaServicio {
     private BusquedaRepository busquedaRepository;


    public BusquedaServicio(BusquedaRepository busquedaRepository) {
        this.busquedaRepository = busquedaRepository;
    
    }

    public List<Busqueda> buscar(String busqueda) {
    	List<Busqueda> res = busquedaRepository.RealizarBusqueda(busqueda);
    	System.out.println("Busqueda realziada. Resultados: ");
    	for (Busqueda busqueda2 : res) {
			System.out.println("" + busqueda2.getNombre());
		}
    	return res;
    }

    public void mostrarDetalles(Busqueda busqueda) {
        if ("Perfil".equals(busqueda.getTipo())) {
            mostrarPerfilUsuario(busqueda.getIdElemento());
        } else if ("Hashtag".equals(busqueda.getTipo())) {
            visualizarZetasPorHashtag(busqueda.getIdElemento());
        }
    }

    private void mostrarPerfilUsuario(int idCuenta) {
        
            App.visualizarPerfil(idCuenta);
        
    }

    private void visualizarZetasPorHashtag(int hashtagID) {
    	App.visualizarZetasPorHashtag(hashtagID);
    }
}
    