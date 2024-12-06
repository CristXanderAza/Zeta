package Persistencia;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;


import logica.Usuario;

public class UserRepository implements IUserRepository{

	
	
	private static List<Usuario> cache;
	
	
	
	public UserRepository() {
		cache = new ArrayList<Usuario>();
	}
	
	
	public static void clean() {
		cache.clear();
	}
	
	@Override
	public int add(Usuario u) {
	    Date todaydate = new Date(System.currentTimeMillis());
	    String sql = "INSERT INTO cuenta (nombre_cuenta, arroba_cuenta, correo_cuenta, verificado_cuenta, fecha_creacion_cuenta, contrasena)"
	               + " VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	         
	        // Establecer los valores para la inserción
	        stmt.setString(1, u.getNombre());
	        stmt.setString(2, u.getUsername());
	        stmt.setString(3, u.getCorreo());
	        stmt.setInt(4, 0); // Suponiendo que "verificado_cuenta" es un valor inicial en 0
	        stmt.setDate(5, todaydate);
	        stmt.setString(6, u.getContrasenia());
	        
	        // Ejecutar la inserción
	        stmt.executeUpdate();
	        
	        // Recuperar el ID generado automáticamente
	        try (ResultSet rs = stmt.getGeneratedKeys()) {
	            if (rs.next()) {
	                return rs.getInt(1); // Retornar el ID generado
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1;
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
					cache.add(usuario);
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
		Usuario u = buscarUsuarioEnCache(id);
		
		if(u != null) {
			return u;
		}
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
				cache.add(usuario);
				return usuario;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public  static  Usuario buscarUsuarioEnCache(int id) {
		for (Usuario usuario : cache) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}
	
	
	public static Usuario obtenerPorID(int id) {
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

	public static List<Usuario> SearchFollowedUsers(int id) {
	    String sql = "SELECT * FROM seguidores WHERE id_seguidor = ?";
	    String sql2 = "SELECT * FROM cuenta WHERE id_cuenta = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql);
	         PreparedStatement stmt2 = con.prepareStatement(sql2)) {

	        // Paso 1: Buscar las cuentas que sigue el usuario
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        List<Integer> idSeguidos = new ArrayList<>();

	        while (rs.next()) {
	            // Guardar el id de las cuentas seguidas
	            idSeguidos.add(rs.getInt("id_cuenta"));
	        }

	        // Paso 2: Buscar cuentas seguidas por el usuario
	        List<Usuario> seguidos = new ArrayList<>();
	        for (Integer indice : idSeguidos) {
	            // Colocar el índice actual a la consulta
	            stmt2.setInt(1, indice);
	            try (ResultSet rs2 = stmt2.executeQuery()) { // Mover el cursor con rs2.next()
	                if (rs2.next()) { // Verifica que hay un registro antes de acceder
	                    String nombreCuentaSeguido = rs2.getString("nombre_cuenta");
	                    String usernameSeguido = rs2.getString("arroba_cuenta");
	                    String correoSeguido = rs2.getString("correo_cuenta");
	                    boolean verificadoSeguido = rs2.getBoolean("verificado_cuenta");
	                    String contraseniaSeguido = rs2.getString("contrasena");

	                    // Añadir cuenta seguida a la lista
	                    Usuario u =new Usuario(indice, nombreCuentaSeguido, correoSeguido, usernameSeguido, contraseniaSeguido, verificadoSeguido);
	                    seguidos.add(u);
	                    cache.add(u);
	                }
	            }
	        }

	        return seguidos;

	    } catch (SQLException e) {
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
		System.out.println( idMicuenta + " esta siguiendo a " + idCuentaseguir);
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
	
	
	public static void dejarDeseguirUsuario(int idMicuenta, int idCuentaseguir) {
		String sql = "Delete from seguidores Where id_seguidor = ? AND id_cuenta = ?";
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
