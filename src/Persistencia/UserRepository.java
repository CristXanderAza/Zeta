package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Usuario;

public class UserRepository implements IUserRepository{

	@Override
	public void add(Usuario u) {
		Date todaydate = new Date(System.currentTimeMillis());
		String sql = "insert into cuenta (nombre_cuenta, arroba_cuenta, correo_cuenta, verificado_cuenta, fecha_creacion_cuenta, contrasena)"
				+ "values (?, ?, ?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, u.getNombre());
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getCorreo());
			stmt.setInt(4, 0);
			stmt.setDate(5, todaydate);
			stmt.setString(6, u.getContrasenia());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario getByUsername(String username) {
		String sql = "select * From cuenta Where arroba_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);){
				stmt.setString(1, username);
				
				//Paso 1: Buscar la cuenta por username
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					//Crear la cuenta si es encontrada
					int id = rs.getInt("id_cuenta");
					String nombreCuenta = rs.getString("nombre_cuenta");
					String username1 = rs.getString("arroba_cuenta");
					String correo = rs.getString("correo_cuenta");
					boolean verificado = rs.getBoolean("verificado_cuenta");
					String contrasenia = rs.getString("contrasena");
					Usuario usuario = new Usuario(id, nombreCuenta, correo, username1, contrasenia, verificado);
					
					//Paso 2: Buscar las cuentas que sigue el usuario
					
					usuario.setSeguidos(UserRepository.SearchFollowedUsers(id));
					return usuario;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public Usuario getByID(int id) {
		String sql = "select * From cuenta Where id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String nombreCuenta = rs.getString("nombre_cuenta");
				String username = rs.getString("arroba_cuenta");
				String correo = rs.getString("correo_cuenta");
				boolean verificado = rs.getBoolean("verificado_cuenta");
				String contrasenia = rs.getString("contrasena");
				
				Usuario usuario = new Usuario(id, nombreCuenta, correo, username, contrasenia, verificado);
				
				usuario.setSeguidos(UserRepository.SearchFollowedUsers(id));
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> getAll() {
		String sql = "select * From cuenta";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while(rs.next()) {
				int id = rs.getInt("id_cuenta");
				String nombreCuenta = rs.getString("nombre_cuenta");
				String username = rs.getString("arroba_cuenta");
				String correo = rs.getString("correo_cuenta");
				boolean verificado = rs.getBoolean("verificado_cuenta");
				String contrasenia = rs.getString("contrasena");
				
				usuarios.add(new Usuario(id, nombreCuenta, correo, username, contrasenia, verificado));
				usuarios.getLast().setSeguidos(UserRepository.SearchFollowedUsers(id));
			}
			return usuarios;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void Update(Usuario u) {
		String sql = "Update Cuenta Set nombre_cuenta = ?, correo_cuenta = ?, arroba_cuenta = ?, contrasena = ? Where id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, u.getNombre());
			stmt.setString(2, u.getCorreo());
			stmt.setString(3, u.getUsername());
			stmt.setString(4, u.getContrasenia());
			stmt.setInt(5, u.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(Usuario u) {
		String sql = "Delete from cuenta Where id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Usuario> SearchFollowedUsers(int id){
		String sql = "select * From seguidores Where id_seguidor = ?";
		String sql2 = "select * From cuenta Where id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				PreparedStatement stmt2 = con.prepareStatement(sql2)){
			
			//Paso 1: Buscar las cuentas que sigue el usuario
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			List<Integer> idSeguidos = new ArrayList<Integer>();
			while(rs.next()) {
				//Guardar el id de las cuentas seguidas
				idSeguidos.add(rs.getInt("id_cuenta"));
			}
			
			//Paso 2: Buscar cuentas seguidas por el usuario
			List<Usuario> seguidos = new ArrayList<Usuario>();
			for(Integer indice : idSeguidos) {
				//colocar el indice actual a la consulta
				stmt2.setInt(1, indice);
				
				ResultSet rs2 = stmt2.executeQuery();
				String nombreCuentaSeguido = rs2.getString("nombre_cuenta");
				String usernameSeguido = rs2.getString("arroba_cuenta");
				String correoSeguido = rs2.getString("correo_cuenta");
				boolean verificadoSeguido = rs2.getBoolean("verificado_cuenta");
				String contraseniaSeguido = rs2.getString("contrasena");
				
				//añadir cuenta seguida a la lista
				seguidos.add(new Usuario(indice, nombreCuentaSeguido, correoSeguido, usernameSeguido, contraseniaSeguido, verificadoSeguido));
			}
			
			return seguidos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Usuario> SearchFollowers(int id){
		String sql = "select * From seguidores Where id_cuenta = ?";
		String sql2 = "select * From cuenta Where id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				PreparedStatement stmt2 = con.prepareStatement(sql2)){
			
			//Paso 1: Buscar las cuentas que siguen al usuario
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			List<Integer> idSeguidores = new ArrayList<Integer>();
			while(rs.next()) {
				//Guardar el id de los seguidores
				idSeguidores.add(rs.getInt("id_seguidor"));
			}
			
			//Paso 2: Obtener informacion de los seguidores
			List<Usuario> seguidores = new ArrayList<Usuario>();
			for(Integer indice : idSeguidores) {
				stmt2.setInt(1, indice);
				
				ResultSet rs2 = stmt2.executeQuery();
				String nombreCuentaSeguido = rs2.getString("nombre_cuenta");
				String usernameSeguido = rs2.getString("arroba_cuenta");
				String correoSeguido = rs2.getString("correo_cuenta");
				boolean verificadoSeguido = rs2.getBoolean("verificado_cuenta");
				String contraseniaSeguido = rs2.getString("contrasena");
				
				//añadir cuenta seguida a la lista
				seguidores.add(new Usuario(indice, nombreCuentaSeguido, correoSeguido, usernameSeguido, contraseniaSeguido, verificadoSeguido));
			}
			return seguidores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	


	
	public static void SeguirUsuario(int idMicuenta, int idCuentaseguir) {
		String sql = "insert into seguidores (id_seguidor, id_cuenta) values (?, ?)";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idMicuenta);
			stmt.setInt(2, idCuentaseguir);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int CantidadSeguidores(int idCuenta) {
		String sql = "select Count(*) From seguidores Where id_cuenta = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idCuenta);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int totalSeguidores = rs.getInt(1);
				return totalSeguidores;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

}