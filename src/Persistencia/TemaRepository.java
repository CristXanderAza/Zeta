package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logica.Tema;

public class TemaRepository  implements ITemaRepository{
	  // CREATE: Agregar un nuevo tema
	@Override
    public void agregarTema(Tema tema) {
        String sql = "INSERT INTO temas (nombre_tema) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tema.getNombre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
    public Tema obtenerTemaPorId(int idTema) {
        String sql = "SELECT * FROM temas WHERE id_tema = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTema);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int temaID = rs.getInt("id_tema");
                String nombreTema = rs.getString("nombre_tema");
                return new Tema(temaID, nombreTema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
    public List<Tema> obtenerTodosLosTemas() {
        List<Tema> temas = new ArrayList<>();
        String sql = "SELECT * FROM temas";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int temaID = rs.getInt("id_tema");
                String nombreTema = rs.getString("nombre_tema");
                temas.add(new Tema(temaID, nombreTema));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temas;
    }

	@Override
    public void actualizarTema(Tema tema) {
        String sql = "UPDATE temas SET nombre_tema = ? WHERE id_tema = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tema.getNombre());
            stmt.setInt(2, tema.getTemaID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
    public void eliminarTema(int idTema) {
        String sql = "DELETE FROM temas WHERE id_tema = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTema);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
