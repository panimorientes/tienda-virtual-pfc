package presentacion.actions;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.Cliente;
import domino.GestorUsuarios;
import excepciones.NoHayConexionesLibresException;
import excepciones.UsuarioIncorrectoException;

public class CrearCliente extends ActionSupport {

	private String nombre = "";
	private String apellido = "";
	private String correo;
	private String pass;
	private String direccion = "";

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public String getPass() {
		return pass;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	private boolean checkCorreo(String email) {
		boolean isValid = false;
		// Initialize reg ex for email.
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;
		// Make the comparison case-insensitive.
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;

	}

	public String execute() {
		System.out.println("Se va a crear un user con email=" + correo
				+ ", pass=" + pass);
		try {
			GestorUsuarios ges = new GestorUsuarios();
			if (correo.isEmpty() || pass.isEmpty() || !checkCorreo(correo))
				throw new UsuarioIncorrectoException();
			else {
				Cliente c = ges.crearCliente(nombre, apellido, correo, pass,
						direccion);
				if (c != null) {
					WebUtils.getSession().removeAttribute("user");
					WebUtils.getSession().setAttribute("user", c);
					return SUCCESS;
				} else {
					return "UsuarioRegistradoException";
				}
			}
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		} catch (UsuarioIncorrectoException e) {
			return "UsuarioIncorrectoException";
		}
	}
}
