package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MencionesRepository implements IMencionesRepository{

	@Override
	public void agregarMencion(int usuarioId, int zetaId) {
		// TODO Auto-generated method stub
		 Date todaydate = new Date(System.currentTimeMillis());
		 String sql = "INSERT INTO mencion_zeta (id_cuenta, id_zeta, fecha) VALUES (?,?,?)";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, usuarioId);
	            stmt.setInt(2, zetaId);
	            stmt.setDate(3, todaydate);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void removerMencion(int usuarioId, int zetaId) {
		// TODO Auto-generated method stub
		 String sql = "Delete from mencion_zeta where id_cuenta = ? and id_zeta = ? ";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, usuarioId);
	            stmt.setInt(2, zetaId);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
