package domino;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.NoHayConexionesLibresException;
import persistencia.AgenteBD;
import persistencia.IAgenteBDProductos;

public class GestorProductos {

	private IAgenteBDProductos i;

	public GestorProductos() throws SQLException {
		i = new AgenteBD();
	}

	public List<Producto> getProductos() throws SQLException,
			NoHayConexionesLibresException {
		return i.getAllProductos();
	}

	public List<Pedido> pedidosCompletados(String correo)
			throws NoHayConexionesLibresException, SQLException {
		return i.pedidosCompletados(correo);
	}

	public void guardarPedido(Pedido pe, Cliente cliente) throws SQLException,
			NoHayConexionesLibresException {
		i.guardarPedido(pe, cliente, pe.getCarro().calcularPrecio());
	}

	public void modificarProducto(int referencia, String nombre,
			String descripcion, double precio, String ruta_imagen,
			String categoria, int unidades) throws SQLException,
			NoHayConexionesLibresException {
		i.modificarProducto(referencia, nombre, descripcion, precio,
				ruta_imagen, categoria, unidades);
	}

	public void quitarProducto(int referencia)
			throws NoHayConexionesLibresException, SQLException {
		i.quitarProducto(referencia);
	}

	public int addProducto(String nombre, String descripcion,
			double precio, String ruta_imagen, String categoria, int unidades)
			throws NoHayConexionesLibresException, SQLException {
		return i.addProducto(nombre, descripcion, precio, ruta_imagen,
				categoria, unidades);
	}

	public List<Producto> getProductosBusqueda(String busqueda,
			List<Producto> lista) {
		List<Producto> resultado = new LinkedList<Producto>();
		busqueda = busqueda.toLowerCase();
		String[] stop_vector = { "de", "y", "o", "si", "u", "e", "en", "que",
				"del", "la", "se", "las", "les", "por", "para", "con", "su",
				"muy", "sin", "ese", "eso", "por", "sobre", "tras" };
		LinkedList<String> stop_list = new LinkedList<String>();

		String palabras[] = busqueda.split(" ");

		for (int ii = 0; ii < stop_vector.length; ii++) {
			stop_list.add(stop_vector[ii]);
		}

		for (Producto pro : lista) {
			for (int ii = 0; ii < palabras.length; ii++) {
				if (!resultado.contains(pro)
						&& !palabras[ii].isEmpty()
						&& !stop_list.contains(palabras[ii])
						&& (pro.getDescripcion().toLowerCase()
								.contains(palabras[ii])
								|| pro.getNombre().toLowerCase()
										.contains(palabras[ii])
								|| palabras[ii].contains(Integer.toString(pro
										.getReferencia())) || pro
								.getCategoria().toLowerCase()
								.contains(palabras[ii]))) {
					resultado.add(pro);
				}
			}
		}

		return resultado;
	}

	public List<Producto> getProductosCategoria(List<Producto> lista,
			String categoria) {
		List<Producto> resultado = new LinkedList<Producto>();

		for (Producto p : lista) {
			if (p.getCategoria().equals(categoria))
				resultado.add(p);
		}

		return resultado;
	}

	public List<String> getAllCategorias()
			throws NoHayConexionesLibresException, SQLException {
		return i.getAllCategorias();
	}
}
