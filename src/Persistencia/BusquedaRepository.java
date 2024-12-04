
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Busqueda;

public class BusquedaRepository implements IBusquedaRepository{

	@Override
	public List<Busqueda> RealizarBusqueda(String busqueda) {
		String sql = "select id_cuenta, arroba_cuenta From cuenta Where arroba_cuenta Like ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, "%"+busqueda+"%");
			ResultSet rs = stmt.executeQuery();
			List<Busqueda> busquedas = new ArrayList<Busqueda>();
			while(rs.next()) {
				int cantidad = UserRepository.CantidadSeguidores(rs.getInt("id_cuenta"));
				busquedas.add(new Busqueda(rs.getInt("id_cuenta"), rs.getString("arroba_cuenta"), "Perfil", cantidad));
			}
			
			busquedas.addAll(BusquedaRepository.BuscarHashtags(busqueda));
			
			return busquedas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Busqueda>();
	}
	
	public static List<Busqueda> BuscarHashtags(String busqueda){
		String sql = "select id_hashtag, nombre From hashtags Where nombre Like ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, "%"+busqueda+"%");
			ResultSet rs = stmt.executeQuery();
			List<Busqueda> busquedas = new ArrayList<Busqueda>();
			while(rs.next()) {
				int cantidad = HashtagRepository.ObtenerCantidad(rs.getInt("id_hashtag"));
				busquedas.add(new Busqueda(rs.getInt("id_hashtag"), rs.getString("nombre"), "Hashtag", cantidad));
			}
			return busquedas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Busqueda>();
	}

}
