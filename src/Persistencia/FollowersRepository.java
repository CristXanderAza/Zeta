package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FollowersRepository implements IFollowersRepository{

	@Override
	public void add(int idSeguido, int idSeguidor) {
		// TODO Auto-generated method stub
		String sql = "insert into seguidores (id_seguidor, id_cuenta) values (?, ?)";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idSeguidor);
			stmt.setInt(2, idSeguido);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idSeguido, int idSeguidor) {
		String sql = "Delete from seguidores Where id_seguidor = ? And id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idSeguidor);
			stmt.setInt(2, idSeguido);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
