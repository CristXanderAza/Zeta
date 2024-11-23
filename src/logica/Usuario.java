package logica;

import java.util.Date;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String username;
	private String contrasenia;
	private List<Usuario> seguidos;
	
	public Usuario(int id, String nombre, String apellido, String username, String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasenia = encriptar(contrasenia);
	}
	
	
	public static String encriptar(String password) {
	        try {
	            // Crear instancia de MessageDigest con SHA-256
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            
	            // Convertir la contraseña en bytes y aplicar el hash
	            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	            
	            // Convertir el resultado en un string hexadecimal
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : encodedHash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }
	            
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error al generar el hash SHA-256", e);
	        }
	}	
	
	
	public Boolean autenticar(String noEncripatadaContrasenia) {
		return (encriptar(noEncripatadaContrasenia).equals(this.contrasenia));
	}
	
	public Zeta zetear(String body) {
		Zeta z = new Zeta(this, body, new Date());
		return z;
	}
	
	public static Usuario placeholder() {
		return new Usuario(0, "Admin", "Admin", "Admin", "Admin");
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public List<Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(List<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	
}
