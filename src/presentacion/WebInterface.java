package presentacion;

import java.sql.SQLException;
import java.util.List;

import domino.Carro;
import domino.Cliente;
import domino.Pedido;
import domino.Producto;
import excepciones.*;

public interface WebInterface {

	public List<Producto> getAllProducts() throws SQLException, NoHayConexionesLibresException, ClassNotFoundException;
	
	public List<String> getAllCategorias() throws NoHayConexionesLibresException, SQLException;	
	
	public List<Producto> getProductosCategoria(List<Producto> lista, String categoria) throws SQLException ;
	
	public List<Producto> getProductosBusqueda(String busqueda, List<Producto> lista) throws SQLException;
	
	public List<Pedido> pedidosCompletados(String correo) throws SQLException, NoHayConexionesLibresException;
	
	public String recuperarPass(String correo) throws SQLException, NoHayConexionesLibresException;

	public void guardarPedido(Pedido p, Cliente c) throws SQLException, NoHayConexionesLibresException;		

}
