package presentacion.actions;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import domino.GestorProductos;
import excepciones.NoHayConexionesLibresException;

public class QuitarProducto extends ActionSupport {

	private int referencia;

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public String execute() {

		try {
			GestorProductos ges = new GestorProductos();
			ges.quitarProducto(referencia);
			return SUCCESS;
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		}
	}

}
