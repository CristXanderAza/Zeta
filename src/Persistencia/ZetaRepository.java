package Persistencia;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;
import java.util.Date;
import logica.Tema;
import logica.Usuario;
import logica.Zeta;

public class ZetaRepository implements IZetasRepository{

	private IUserRepository usuarioRepo;
	private ITemaRepository temaRepo;
	
	public ZetaRepository(IUserRepository usuarioRepo, ITemaRepository temaRepo) {
		super();
		this.usuarioRepo = usuarioRepo;
		this.temaRepo = temaRepo;
	}

	
	@Override
	public void agregarZeta(Zeta z) {
		// TODO Auto-generated method stub
		String insertQuery = "insert into zetas(id_cuenta,id_tema,contenido,zeta_padre, fecha_creacion, hilo_zeta, id_archivo)\r\n"
				+ "values (?,?,?,?,?,?,?);";
		String selectLastIdQuery = "SELECT LAST_INSERT_ID();";
		
		 try (Connection conn = DBConnection.getConnection();
		         PreparedStatement ps = conn.prepareStatement(insertQuery)) {
		        // Configurar los parámetros
		        
		        ps.setInt(1, z.getUsuario().getId());
		        ps.setInt(2, z.getTema().getTemaID());
		        ps.setString(3, z.getBody());
		        if (z.getParent() != null) {
		            ps.setInt(4, z.getParent().getId());
		        } else {
		            ps.setNull(4, Types.INTEGER);
		        }
		        ps.setTimestamp(5, new Timestamp(System.currentTimeMillis())); // Establecer la fecha actual
		        
		        if(z.getHilo() != null) {
		        	ps.setInt(6, z.getHilo().getId());
		        	
		        }
		        else {
		        	 ps.setNull(6, Types.INTEGER);
		        }
		        
				if(!z.getImageReference().isBlank()) {
					ps.setInt(7, z.getImageID());
				}
				else {
					 ps.setNull(7, Types.INTEGER);
				}
				
		        // Ejecutar la consulta
		        int rowsAffected = ps.executeUpdate();

		        // Si se insertó con éxito, obtener el ID autogenerado
		        if (rowsAffected > 0) {
		            try (PreparedStatement psLastId = conn.prepareStatement(selectLastIdQuery);
		                    ResultSet rs = psLastId.executeQuery()) {
		                   if (rs.next()) {
		                       z.setId(rs.getInt(1)); // Asignar el ID generado al objeto Zeta
		                   }
		               }
		            
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public Zeta getById(int id) {
		// TODO Auto-generated method stub
		// Consulta SQL con LEFT JOIN y subconsulta EXISTS para likedByUser
	    String query = "SELECT z.id_zeta, z.id_cuenta, z.id_tema, z.contenido, z.fecha_creacion, "
	                 + "z.zeta_padre, z.hilo_zeta, a.ruta_archivo AS imageReference, z.likes, "
	                 + "EXISTS ("
	                 + "    SELECT 1 "
	                 + "    FROM likes_zeta l "
	                 + "    WHERE l.id_zeta = z.id_zeta AND l.id_cuenta = ?"
	                 + ") AS likedByUser "
	                 + "FROM zetas z "
	                 + "LEFT JOIN archivos a ON z.imageReference = a.id_archivo "
	                 + "WHERE z.id_zeta = ?";

	    try (Connection conn = DBConnection.getConnection(); // Obtener conexión a la base de datos
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        // Usuario actual
	        Usuario actual = Usuario.getActual();
	        if (actual == null) {
	            throw new IllegalStateException("No hay un usuario actual autenticado.");
	        }

	        stmt.setInt(1, actual.getId()); // Parámetro para la subconsulta de likedByUser
	        stmt.setInt(2, id);            // Parámetro para el id del Zeta

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                // Obtener datos desde el ResultSet
	                int zetaId = rs.getInt("id_zeta");
	                int idUsuario = rs.getInt("id_cuenta");
	                int idTema = rs.getInt("id_tema");
	                String body = rs.getString("contenido");
	                Date fecha = rs.getTimestamp("fecha_creacion");
	                int hiloID = rs.getInt("hilo_zeta");
	                String imageReference = rs.getString("imageReference"); // Puede ser null
	                int likesCantity = rs.getInt("likes");
	                boolean likedByUser = rs.getBoolean("likedByUser");

	                // Obtener el usuario desde el repositorio de usuarios
	                Usuario usuario = usuarioRepo.getByID(idUsuario);

	                // Obtener el tema desde el repositorio de temas
	                Tema tema = temaRepo.obtenerTemaPorId(idTema);

	                // Obtener Zeta padre (si existe)
	                Zeta parent = null;
	                int zetaPadreId = rs.getInt("zeta_padre");
	                if (!rs.wasNull()) {
	                    parent = getById(zetaPadreId); // Llamada recursiva
	                }

	                // Crear y retornar la instancia de Zeta
	                return new Zeta(zetaId, usuario, body, fecha, imageReference, hiloID, tema, parent, likedByUser);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; 
	}

	@Override
	public List<Zeta> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(Zeta zeta) {
		// TODO Auto-generated method stub
	    String query = "UPDATE zetas SET contenido = ?, cantidad_likes = ?,  WHERE id_zeta = ?;";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, zeta.getBody());
	       //ps.setInt(2, zeta.getLikesCantity());
	   
	        ps.setInt(3, zeta.getId());

	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	}
	
	public void Update(Zeta zeta, int imageId) {
		// TODO Auto-generated method stub
	    String query = "UPDATE zetas SET contenido = ?, cantidad_likes = ?, id_archivo = ? WHERE id_zeta = ?;";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, zeta.getBody());
	        ps.setInt(2, zeta.getLikesCantity());
	        
	            ps.setInt(3, imageId);
	     
	        ps.setInt(4, zeta.getId());

	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }
	}

	@Override
	public void remove(Zeta z) {
		// TODO Auto-generated method stub
	    String query = "DELETE FROM zetas WHERE id_zeta = ?;";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setInt(1, z.getId());

	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	      
	    }
	}

	@Override
	public List<Zeta> obtenerPorHastag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zeta> obtenerPorTema(Tema t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Zeta> obtenerPorUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int agregarImagen(String rutaArchivo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void agregarZetaConImagen(Zeta z, int archivoID) {
		// TODO Auto-generated method stub
		
	}

}