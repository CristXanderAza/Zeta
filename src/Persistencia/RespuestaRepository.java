package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.LikeInteraccion;
import logica.Respuesta;
import logica.Tema;
import logica.Usuario;
import logica.Zeta;

public class RespuestaRepository implements IRespuestaRepository{
	

	private IUserRepository usuarioRepository;
	private IZetasRepository zetaRepository;
	
	public RespuestaRepository(IUserRepository usuarioRepository, IZetasRepository zetaRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.zetaRepository = zetaRepository;
	}

	
	@Override
	public void agregarRespuesta(Respuesta r) {
		// TODO Auto-generated method stub
		String insertQuery = "insert into comentario (id_zeta, id_cuenta, contenido, fecha_creacion)\r\n"
				+ "values (?,?,?,?);";
		String selectLastIdQuery = "SELECT LAST_INSERT_ID();";
		
		 try (Connection conn = DBConnection.getConnection();
		         PreparedStatement ps = conn.prepareStatement(insertQuery)) {
		        // Configurar los parámetros
		        
		        ps.setInt(1, r.getZetaAContestar().getId());
		        ps.setInt(2, r.getUsuario().getId());
		        ps.setString(3, r.getBody());
		        ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // Establecer la fecha actual
		        
		     
				
		        // Ejecutar la consulta
		        int rowsAffected = ps.executeUpdate();

		        // Si se insertó con éxito, obtener el ID autogenerado
		        if (rowsAffected > 0) {
		            try (PreparedStatement psLastId = conn.prepareStatement(selectLastIdQuery);
		                    ResultSet rs = psLastId.executeQuery()) {
		                   if (rs.next()) {
		                       r.setId(rs.getInt(1)); // Asignar el ID generado al objeto Zeta
		                   }
		               }
		            
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public List<Respuesta> obtenerRespuestasDeZeta(Zeta z) {
		// TODO Auto-generated method stub
		List<Respuesta> res = new ArrayList<Respuesta>();
	    String query = "Select c.*,  "
                + "EXISTS ("
                + "    SELECT 1 "
                + "    FROM likes_comentario l "
                + "    WHERE l.id_comentario = c.id_comentario AND l.id_cuenta = ?"
                + ") AS likedByUser "
                + "from comentario c "
               // + "LEFT JOIN archivos a ON z.id_archivo = a.id_archivo "
                + "where c.id_zeta = ?"
                ;

   try (Connection conn = DBConnection.getConnection(); // Obtener conexión a la base de datos
        PreparedStatement stmt = conn.prepareStatement(query)) {
       // Usuario actual
       Usuario actual = Usuario.getActual();
       if (actual == null) {
           throw new IllegalStateException("No hay un usuario actual autenticado.");
       }

       stmt.setInt(1, actual.getId()); // Parámetro para la subconsulta de likedByUser
       stmt.setInt(2, z.getId());          // Parámetro para el id del Zeta

       try (ResultSet rs = stmt.executeQuery()) {
    	   while  (rs.next()) {
               // Obtener datos desde el ResultSet
               int resID = rs.getInt("id_comentario");
               int idUsuario = rs.getInt("id_cuenta");
               int idZeta = rs.getInt("id_zeta");
               String body = rs.getString("contenido");
               Date fecha = rs.getTimestamp("fecha_creacion");
              
               // Puede ser null
               int likesCantity = rs.getInt("likes");
               boolean likedByUser = (rs.getInt("likedByUser") == 1);

               // Obtener el usuario desde el repositorio de usuarios
               Usuario usuario = usuarioRepository.getByID(idUsuario);

               // Obtener el tema desde el repositorio de temas

               // Obtener Zeta padre (si existe)
        
               // Crear y retornar la instancia de Zeta
               Respuesta r = new Respuesta(resID, usuario, body,  fecha,
           			 z,  likesCantity,  likedByUser);
               System.out.println(z.getBody());
               r.setLikesCantity(likesCantity);
               
               res.add(r);
           }
        }
	   } catch (SQLException e) {
		   System.out.println(e.getMessage());
	       e.printStackTrace();
	   }
   		return res;
		
	}

	@Override
	public Respuesta obtenerRespuestaPorId(int respId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarRespuesta(Respuesta r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarRespuesta(int respuestaId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darLike(LikeInteraccion li) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarLike(Usuario u, Respuesta r) {
		// TODO Auto-generated method stub
		
	}

}
