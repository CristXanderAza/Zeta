package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Notificacion;

public class NotifyRepository implements INotifyRepository{

	@Override
	public List<Notificacion> ObtenerNotificaiones(int idReceptor) {
		String sql = "SELECT lz.id_zeta, lz.fecha, lz.id_cuenta"
				+ " From zetas z"
				+ " Inner Join likes_zeta lz On z.id_zeta = lz.id_zeta"
				+ " Where z.id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idReceptor);
			ResultSet rs = stmt.executeQuery();
			List<Notificacion> notificaciones = new ArrayList<Notificacion>();
			while(rs.next()) {
				notificaciones.add(new Notificacion(idReceptor, rs.getInt("id_cuenta"), rs.getInt("id_zeta"), "LikeZeta", rs.getDate("fecha")));
			}
			
			notificaciones.addAll(NotifyRepository.ObtenerLikesComentarios(idReceptor));
			notificaciones.addAll(NotifyRepository.ObtenerMencionesZeta(idReceptor));
			notificaciones.addAll(NotifyRepository.ObtenerMencionesComentarios(idReceptor));
			notificaciones.addAll(NotifyRepository.ObtenerComentarios(idReceptor));
			
			notificaciones.sort((n1, n2) -> n2.getFecha().compareTo(n1.getFecha()));
			
			return notificaciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Notificacion>();
	}
	
	public static List<Notificacion> ObtenerLikesComentarios(int idReceptor) {
		String sql = "SELECT lc.id_comentario, lc.fecha, lc.id_cuenta"
				+ " From comentario c"
				+ " Inner Join likes_comentario lc On c.id_comentario = lc.id_comentario"
				+ " Where c.id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idReceptor);
			ResultSet rs = stmt.executeQuery();
			List<Notificacion> notificaciones = new ArrayList<Notificacion>();
			while(rs.next()) {
				notificaciones.add(new Notificacion(idReceptor, rs.getInt("id_cuenta"), rs.getInt("id_comentario"), "LikeComentario", rs.getDate("fecha")));
			}
			
			return notificaciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Notificacion>();
	}
	
	public static List<Notificacion> ObtenerMencionesZeta(int idReceptor){
		String sql = "SELECT mz.id_zeta, mz.fecha, z.id_cuenta "
					+ "FROM mencion_zeta mz "
					+ "Inner Join zetas z ON mz.id_zeta = z.id_zeta "
					+ "Where mz.id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idReceptor);
			List<Notificacion> notificaciones = new ArrayList<Notificacion>();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				notificaciones.add(new Notificacion(idReceptor, rs.getInt("id_cuenta"), rs.getInt("id_zeta"), "MencionZeta", rs.getDate("fecha")));
			}
			
			return notificaciones;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Notificacion>();
		
	}
	
	public static List<Notificacion> ObtenerMencionesComentarios(int idReceptor){
		String sql = "SELECT mc.id_comentario, mc.fecha, c.id_cuenta "
				+ "FROM mencion_comentarios mc "
				+ "Inner Join comentario c ON mc.id_comentario = c.id_comentario "
				+ "Where mc.id_cuenta = ?";
	try (Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
		stmt.setInt(1, idReceptor);
		List<Notificacion> notificaciones = new ArrayList<Notificacion>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			notificaciones.add(new Notificacion(idReceptor, rs.getInt("id_cuenta"), rs.getInt("id_comentario"), "MencionComentario", rs.getDate("fecha")));
		}
		
		return notificaciones;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new ArrayList<Notificacion>();
		
	}
	
	public static List<Notificacion> ObtenerComentarios(int idReceptor){
		String sql = "SELECT c.id_cuenta, c.id_comentario, c.fecha_creacion "
				+ "From comentario c "
				+ "Inner Join zetas z ON c.id_zeta = z.id_zeta "
				+ "Where z.id_cuenta = ? ";
	try (Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
		stmt.setInt(1, idReceptor);
		List<Notificacion> notificaciones = new ArrayList<Notificacion>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			notificaciones.add(new Notificacion(idReceptor, rs.getInt("id_cuenta"), rs.getInt("id_comentario"), "Comentario", rs.getDate("fecha_creacion")));
		}
		
		return notificaciones;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return new ArrayList<Notificacion>();
	}

}
