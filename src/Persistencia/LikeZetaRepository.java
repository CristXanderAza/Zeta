package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Usuario;

public class LikeZetaRepository implements ILikeRepository{

private UserRepository userRepo;
	
	public LikeZetaRepository(UserRepository userRepo) {
		setUserRepo(userRepo);
	}
	


	@Override
	public void AddLike(int idCuenta, int idElemento) {
		Date todaydate = new Date(System.currentTimeMillis());
		String sql = "insert into likes_zeta (id_cuenta, id_zeta, fecha) values (?, ?, ?)";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idCuenta);
			stmt.setInt(2, idElemento);
			stmt.setDate(3, todaydate);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void DeleteLike(int idCuenta, int idElemento) {
		String sql = "delete From likes_zeta Where id_cuenta = ? And id_zeta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idCuenta);
			stmt.setInt(2, idElemento);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Usuario> SearchUsers(int idElemento) {
		String sql = "select id_cuenta from likes_zeta Where id_zeta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idElemento);
			ResultSet rs = stmt.executeQuery();
			List<Integer> ids = new ArrayList<Integer>();
			
			while(rs.next()) {
				ids.add(rs.getInt("id_cuenta"));
			}
			
			List<Usuario> usuarios = new ArrayList<Usuario>();
			
			for(Integer id : ids) {
				usuarios.add(this.userRepo.getByID(id));
			}
			
			return usuarios;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//Getters and setters
	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}


}
