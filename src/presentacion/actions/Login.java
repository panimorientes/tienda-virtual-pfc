package presentacion.actions;

import java.sql.SQLException;

import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.GestorUsuarios;
import domino.Usuario;
import excepciones.NoHayConexionesLibresException;
import excepciones.UsuarioIncorrectoException;

public class Login extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String correo;
	private String pass;

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String execute() {
		try {
			GestorUsuarios ges = new GestorUsuarios();
			Usuario u = ges.login(correo, pass);
			if (u != null) {

				if (u.getCorreo() != null) {
					WebUtils.getSession().removeAttribute("user");
					WebUtils.getSession().setAttribute("user", u);
				}
				return SUCCESS;
			} else {
				throw new UsuarioIncorrectoException();
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
