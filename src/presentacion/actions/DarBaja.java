package presentacion.actions;

import java.sql.SQLException;

import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.Cliente;
import domino.GestorProductos;
import domino.GestorUsuarios;
import excepciones.NoHayConexionesLibresException;

public class DarBaja extends ActionSupport {

	public String execute() {

		try {
			GestorUsuarios ges = new GestorUsuarios();
			Cliente c=((Cliente) WebUtils.getSession().getAttribute("user"));
			String correo=c.getCorreo();
			ges.darBaja(correo);
			WebUtils.getSession().removeAttribute("user");
			return SUCCESS;
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		}
	}
}
