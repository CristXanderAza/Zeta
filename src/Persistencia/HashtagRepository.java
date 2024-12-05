package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logica.Hashtag;
import logica.HashtagWithDataDTO;

public class HashtagRepository implements IHashtagRepository {
    


    @Override
    public void agregarHashtag(Hashtag h)  {
    	    String sql = "INSERT INTO hashtags (nombre) VALUES (?)";
    	    try (Connection con = DBConnection.getConnection();
    	         PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    	        
    	        // Establecer el valor del parámetro
    	        stmt.setString(1, h.getNombre());
    	        
    	        // Ejecutar la inserción
    	        int affectedRows = stmt.executeUpdate();
    	        
    	        if (affectedRows == 0) {
    	            throw new SQLException("No se pudo insertar el hashtag, no se afectaron filas.");
    	        }
    	        
    	        // Recuperar la clave generada automáticamente
    	        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
    	            if (generatedKeys.next()) {
    	                // Asignar el ID generado al objeto Hashtag
    	                h.setID(generatedKeys.getInt(1));
    	            } else {
    	                throw new SQLException("No se pudo obtener el ID generado para el hashtag.");
    	            }
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	}

    @Override
    public Hashtag obtenerPorId(int idHashtag) {
        String sql = "SELECT * FROM hashtags WHERE id_hashtag = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idHashtag);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_hashtag");
                String nombre = rs.getString("nombre");
                return new Hashtag(id, nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public Hashtag obtenerPorNombre(String  txt) {
        String sql = "SELECT * FROM hashtags WHERE nombre = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, txt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_hashtag");
                String nombre = rs.getString("nombre");
                return new Hashtag(id, nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Hashtag> obtenerTodos() {
        List<Hashtag> hashtags = new ArrayList<>();
        String sql = "SELECT * FROM hashtags";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id_hashtag");
                String nombre = rs.getString("nombre");
                hashtags.add(new Hashtag(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashtags;
    }

    @Override
    public void actualizar(Hashtag h) {
        String sql = "UPDATE hashtags SET nombre = ? WHERE id_hashtag = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, h.getNombre());
            stmt.setInt(2, h.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idHashtag) {
        String sql = "DELETE FROM hashtags WHERE id_hashtag = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idHashtag);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void agregarZetaAHashtag(int idZeta, int idHashtag) {
		// TODO Auto-generated method stub
        String sql = "INSERT INTO hashtags_zetas (id_zeta, id_hashtag) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idZeta);
            stmt.setInt(2, idHashtag);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static int ObtenerCantidad(int idHashtag) {
		String sql = "select Count(*) From hashtags_zetas Where id_hashtag = ?";
		try (Connection con = DBConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, idHashtag);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int totalHashtags = rs.getInt(1);
				return totalHashtags;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
    
    public static List<HashtagWithDataDTO> obtenerTop4() {
        List<HashtagWithDataDTO> hashtags = new ArrayList<>();
        String sql = "SELECT * FROM hashtags limit 4";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id_hashtag");
                String nombre = rs.getString("nombre");
                int can = ObtenerCantidad(id);
                hashtags.add(new HashtagWithDataDTO(id, nombre, can));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashtags;
    }
	
	
}