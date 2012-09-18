package presentacion.actions;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import domino.Cliente;
import domino.GestorProductos;
import domino.Pedido;
import excepciones.NoHayConexionesLibresException;

public class GuardarPedido extends ActionSupport {

	private Pedido pedido;
	private Cliente cliente;

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String execute() {
		try {
			GestorProductos ges = new GestorProductos();
			ges.guardarPedido(pedido, cliente);
			return SUCCESS;
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		}
	}
}
