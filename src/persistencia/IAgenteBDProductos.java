package persistencia;

import java.sql.SQLException;
import java.util.List;

import domino.Cliente;
import domino.Pedido;
import domino.Producto;
import excepciones.NoHayConexionesLibresException;

public interface IAgenteBDProductos {
	
	public List<Producto> getAllProductos() throws SQLException,
	NoHayConexionesLibresException;
	
	public List<Pedido> pedidosCompletados(String correo)
			throws NoHayConexionesLibresException, SQLException;

	public void guardarPedido(Pedido pe, Cliente cliente, double precio) throws SQLException,
			NoHayConexionesLibresException;
	
	public void modificarProducto(int referencia, String nombre,
			String descripcion, double precio, String ruta_imagen,
			String categoria, int unidades) throws SQLException,
			NoHayConexionesLibresException;

	public void quitarProducto(int referencia)
			throws NoHayConexionesLibresException, SQLException;

	public int addProducto(String nombre, String descripcion,
			double precio, String ruta_imagen, String categoria, int unidades)
			throws NoHayConexionesLibresException, SQLException;
	
	public List<String> getAllCategorias() throws NoHayConexionesLibresException, SQLException;

}
