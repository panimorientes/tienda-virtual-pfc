package domino;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.NoHayConexionesLibresException;

import presentacion.WebInterface;

public class FachadaPresentacionDominio implements WebInterface {

	@Override
	public List<Producto> getAllProducts() throws SQLException,
			NoHayConexionesLibresException {
		GestorProductos ges = new GestorProductos();
		return ges.getProductos();
	}

	@Override
	public List<Producto> getProductosBusqueda(String busqueda,
			List<Producto> lista) throws SQLException {
		GestorProductos ges = new GestorProductos();
		return ges.getProductosBusqueda(busqueda, lista);
	}

	@Override
	public List<Producto> getProductosCategoria(List<Producto> lista,
			String categoria) throws SQLException {
		GestorProductos ges = new GestorProductos();
		return ges.getProductosCategoria(lista, categoria);
	}
	
	@Override
	public List<String> getAllCategorias() throws NoHayConexionesLibresException, SQLException{
		GestorProductos ges = new GestorProductos();
		return ges.getAllCategorias();
	}
	
	@Override
	public String recuperarPass(String correo) throws SQLException, NoHayConexionesLibresException{
		GestorUsuarios ges=new GestorUsuarios();
		return ges.recuperarPass(correo);
	}

	@Override
	public List<Pedido> pedidosCompletados(String correo) throws SQLException, NoHayConexionesLibresException {
		GestorProductos ges = new GestorProductos();
		return ges.pedidosCompletados(correo);
	}
	
	@Override
	public void guardarPedido(Pedido p, Cliente c) throws SQLException, NoHayConexionesLibresException{
		GestorProductos ges = new GestorProductos();
		ges.guardarPedido(p, c);
	}
}
