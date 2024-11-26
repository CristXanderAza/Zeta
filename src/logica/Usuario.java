package logica;

import java.util.Date;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
	
	private int id;
	private String nombreCuenta;
	private String correo;
	private String username;
	private String contrasenia;
	private Boolean verificado;
	private List<Usuario> seguidos;
	private static Usuario actual;

	public Usuario(int id, String nombre, String correo, String username, String contrasenia, Boolean verificado) {
		super();
		this.id = id;
		this.nombreCuenta = nombre;
		this.correo = correo;
		this.username = username;
		this.contrasenia = encriptar(contrasenia);
		this.verificado = verificado;
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
		return new Usuario(0, "Admin", "Admin", "Admin", "Admin", true);
	}
	
	
	public Boolean getVerificado() {
		return verificado;
	}


	public void setVerificado(Boolean verificado) {
		this.verificado = verificado;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombreCuenta;
	}

	public void setNombre(String nombre) {
		this.nombreCuenta = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String apellido) {
		this.correo = apellido;
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

	public static Usuario getActual() {
		return actual;
	}


	public static void setActual(Usuario actual) {
		Usuario.actual = actual;
	}


	
}
