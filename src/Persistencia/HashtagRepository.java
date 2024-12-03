package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logica.Hashtag;

public class HashtagRepository implements IHashtagRepository {
    


    @Override
    public void agregarHashtag(Hashtag h) {
        String sql = "INSERT INTO hashtags (nombre) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, h.getNombre());
            stmt.executeUpdate();
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
}