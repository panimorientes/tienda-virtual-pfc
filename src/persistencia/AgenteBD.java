package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import domino.Administrador;
import domino.Carro;
import domino.Cliente;
import domino.PaqueteProducto;
import domino.Pedido;
import domino.Producto;
import domino.Usuario;
import excepciones.*;

public class AgenteBD implements IAgenteBD, IAgenteBDProductos {
	public static int numero_conexiones = 2;
	static Vector<Conexion> conexiones;

	public AgenteBD() throws SQLException {
		super();
		conexiones = new Vector<Conexion>(numero_conexiones);
		for (int i = 0; i < numero_conexiones; i++)
			conexiones.add(new Conexion());
		for (Conexion c : conexiones) {
			c.connect();
		}
	}

	public Conexion getConexionLibre() throws NoHayConexionesLibresException {
		for (Conexion c : conexiones) {
			if (c.isFree()) {
				c.setFree(false);// ocupado
				return c;
			}
		}
		throw new NoHayConexionesLibresException();
	}

	private void liberar(Conexion c) throws SQLException {
		c.setFree(true);
	}

	public Usuario login(String correo, String pass)
			throws NoHayConexionesLibresException, SQLException {
		Usuario res = null;
		Conexion c = getConexionLibre();

		String consulta = "SELECT * FROM Usuario, Administrador WHERE (Administrador.email = Usuario.email AND Usuario.email = '"
				+ correo + "' AND Usuario.password = '" + pass + "');";

		String consulta2 = "SELECT * FROM Usuario, Cliente WHERE (Cliente.email = Usuario.email AND Usuario.email = '"
				+ correo + "' AND Usuario.password = '" + pass + "');";

		ResultSet r = c.execute(consulta);
		ResultSet r2 = c.execute(consulta2);
		if (r.next()) {
			String nombre = r.getString("nombre");
			String apellido = r.getString("apellido");
			String password = r.getString("password");
			res = new Administrador(nombre, apellido, correo, password);
		} else if (r2.next()) {
			String direccion = r2.getString("direccion");
			String nombre = r2.getString("nombre");
			String apellido = r2.getString("apellido");
			String password = r2.getString("password");
			res = new Cliente(nombre, apellido, correo, password, direccion);
		}
		liberar(c);
		return res;
	}

	public Cliente crearCliente(String nombre, String apellido, String correo,
			String pass, String direccion)
			throws NoHayConexionesLibresException, SQLException {

		String consulta = "INSERT INTO Usuario VALUES ('" + correo + "', '"
				+ pass + "', '" + nombre + "', '" + apellido + "');";

		String consulta2 = "INSERT INTO Cliente VALUES ('" + correo + "', '"
				+ direccion + "');";

		Conexion c = getConexionLibre();

		c.update(consulta);
		c.update(consulta2);

		Cliente client = new Cliente(nombre, apellido, correo, pass, direccion);

		liberar(c);
		return client;
	}

	public Cliente getCliente(String correo)
			throws NoHayConexionesLibresException, SQLException {
		Cliente cliente = null;
		String consulta_getCliente = "SELECT * FROM Cliente, Usuario WHERE (Cliente.email = Usuario.email AND Cliente.email = '"
				+ correo + "');";
		Conexion c = getConexionLibre();

		ResultSet r = c.execute(consulta_getCliente);
		String nombre, apellido, pass, direccion;
		if (r.next()) {
			nombre = r.getString("nombre");
			apellido = r.getString("apellido");
			pass = r.getString("password");
			direccion = r.getString("direccion");
			cliente = new Cliente(nombre, apellido, correo, pass, direccion);
		}

		liberar(c);
		return cliente;
	}

	public List<Producto> getAllProductos() throws SQLException,
			NoHayConexionesLibresException {
		String consulta_getProductos = "SELECT * FROM Producto;";
		List<Producto> productos = new LinkedList<Producto>();

		Conexion c = getConexionLibre();
		ResultSet r = c.execute(consulta_getProductos);

		while (r.next()) {
			int referencia = r.getInt("referencia");
			String nombre = r.getString("nombre");
			String descripcion = r.getString("descripcion");
			double precio = r.getDouble("precio");
			String ruta_imagen = r.getString("ruta_imagen");
			String categoria = r.getString("categoria");
			int unidades = r.getInt("stock");
			Producto pro = new Producto(referencia, nombre, descripcion,
					precio, ruta_imagen, categoria, unidades);

			if (!esVacio(pro))
				productos.add(pro);
		}
		liberar(c);

		return productos;
	}

	private boolean esVacio(Producto prod) {
		boolean vacio = false;

		if (prod.getNombre().equals("null")) {
			vacio = true;
		}

		return vacio;
	}

	public void darBaja(String correo) throws NoHayConexionesLibresException,
			SQLException {
		String consulta_darBaja = "DELETE FROM Cliente WHERE (email = '"
				+ correo + "');";
		Conexion c = getConexionLibre();
		c.update(consulta_darBaja);
		consulta_darBaja = "DELETE FROM Usuario WHERE (email = '" + correo
				+ "');";
		c.update(consulta_darBaja);

		liberar(c);
	}

	public void modificarCliente(String nombre, String apellidos,
			String correo, String pass, String direccion)
			throws NoHayConexionesLibresException, SQLException {
		String consulta_modificarCliente = "UPDATE Cliente SET direccion = '"
				+ direccion + "' WHERE email = '" + correo + "';";
		Conexion c = getConexionLibre();
		c.update(consulta_modificarCliente);

		consulta_modificarCliente = "UPDATE Usuario SET nombre = '" + nombre
				+ "', apellido = '" + apellidos + "', password = '" + pass
				+ "' WHERE email = '" + correo + "';";
		c.update(consulta_modificarCliente);
		liberar(c);

	}
	
	public List<Pedido> pedidosCompletados(String correo)
			throws NoHayConexionesLibresException, SQLException {
		String consulta_pedidos = "SELECT id, fecha FROM Pedido WHERE (cliente = '"
				+ correo + "');";
		List<Pedido> resultado = new LinkedList<Pedido>();

		Conexion c = getConexionLibre();
		
		ResultSet r = c.execute(consulta_pedidos);
		
		while (r.next()) {
			List<PaqueteProducto> productos = new LinkedList<PaqueteProducto>();

			
			String fecha = r.getString("fecha");
			String id = r.getString("id");	
			
			String consulta_productos = "SELECT PaqueteProducto.nombre_producto, Producto.referencia, PaqueteProducto.precio, Producto.categoria, PaqueteProducto.descripcion, Producto.ruta_imagen, Producto.stock, PaqueteProducto.n FROM Producto, Pedido, PaqueteProducto WHERE (Producto.referencia = PaqueteProducto.producto AND Pedido.id = PaqueteProducto.pedido AND Pedido.id = '"
					+ id + "');";
			ResultSet r2 = c.execute(consulta_productos);
			while (r2.next()) {

				int referencia = r2.getInt("referencia");
				String nombre = r2.getString("nombre_producto");
				int unidades = r2.getInt("n");
				String categoria = r2.getString("categoria");
				String descripcion = r2.getString("descripcion");
				double precio = r2.getDouble("precio");
				String ruta_imagen = r2.getString("ruta_imagen");
				int stock = r2.getInt("stock");

				productos.add(new PaqueteProducto(new Producto(referencia,
						nombre, descripcion, precio, ruta_imagen, categoria,
						stock), unidades));
			}
			

			Pedido pe = new Pedido(fecha, new Carro(productos));
			resultado.add(pe);
		}

		liberar(c);
		return resultado;

	}

	public void guardarPedido(Pedido pe, Cliente cliente, double precio)
			throws SQLException, NoHayConexionesLibresException {
		String consulta_guardarPedido = "INSERT INTO Pedido (fecha, cliente, precio) VALUES ('"
				+ pe.getFecha()
				+ "', '"
				+ cliente.getCorreo()
				+ "', '"
				+ precio + "');";
		String consulta_get_ultimo_pedido = "SELECT Count(*) AS numero FROM Pedido;";
		
		
		Conexion c = getConexionLibre();
		c.update(consulta_guardarPedido);
		
		
		ResultSet r = c.execute(consulta_get_ultimo_pedido);
		r.next();
		int numero_pedido = r.getInt("numero");
		
		for (PaqueteProducto p : pe.getCarro().getLista_productos()) {
			String consulta_guardar_paquete_producto = "INSERT INTO PaqueteProducto VALUES ('"
					+ numero_pedido
					+ "', '"
					+ p.getProducto().getReferencia()
					+ "', '"
					+ p.getCantidad()
					+ "', '"
					+ p.getProducto().getNombre()
					+ "', '"
					+ p.getProducto().getDescripcion()
					+ "', '"
					+ p.getProducto().getPrecio() + "');";
			c.update(consulta_guardar_paquete_producto);
		}

		liberar(c);
	}

	public String recuperarPass(String correo)
			throws NoHayConexionesLibresException, SQLException {
		String consulta_recuperarPass = "SELECT password FROM Usuario WHERE (email = '"
				+ correo + "');";
		Conexion c = getConexionLibre();

		ResultSet r = c.execute(consulta_recuperarPass);
		String pass = "";
		if (r.next()) {
			pass = r.getString("password");
		}
		liberar(c);

		return pass;
		// enviamos

	}

	/*
	 * private void enviarMail(String correo,String mensaje){ Properties
	 * props=new Properties(); props.put("mail.smtp.host",
	 * "smtp."+correo.split("@")[1]); props.put("mail.smtp.port", "587");
	 * 
	 * //props.setProperty("mail.smtp.user", "NuestraTienda"); Session s; }
	 */

	public void modificarProducto(int referencia, String nombre,
			String descripcion, double precio, String ruta_imagen,
			String categoria, int unidades) throws SQLException,
			NoHayConexionesLibresException {
		String consulta_modificarProducto = "UPDATE Producto SET nombre = '"
				+ nombre + "', precio = '" + precio + "', categoria = '"
				+ categoria + "', descripcion = '" + descripcion
				+ "', ruta_imagen = '" + ruta_imagen + "', stock = '"
				+ unidades + "' WHERE referencia = '" + referencia + "';";
		Conexion c = getConexionLibre();
		c.update(consulta_modificarProducto);
		liberar(c);
	}

	public void quitarProducto(int referencia)
			throws NoHayConexionesLibresException, SQLException {
		String consulta_quitarProducto = "DELETE FROM Producto WHERE referencia = '"
				+ referencia + "';";

		Conexion c = getConexionLibre();
		c.update(consulta_quitarProducto);
		liberar(c);
	}

	public int addProducto(String nombre, String descripcion, double precio,
			String ruta_imagen, String categoria, int unidades)
			throws NoHayConexionesLibresException, SQLException {

		String consulta_addProducto = "INSERT INTO Producto (nombre, precio, categoria, descripcion, ruta_imagen, stock) VALUES ('"
				+ nombre
				+ "', '"
				+ precio
				+ "', '"
				+ categoria
				+ "', '"
				+ descripcion
				+ "', '"
				+ ruta_imagen
				+ "', '"
				+ unidades
				+ "');";
		Conexion c = getConexionLibre();
		c.update(consulta_addProducto);
		String consulta_ultimo_producto = "SELECT referencia FROM Producto ORDER BY referencia DESC;";
		ResultSet r = c.execute(consulta_ultimo_producto);
		r.next();
		liberar(c);
		return r.getInt("referencia");
	}

	public List<String> getAllCategorias()
			throws NoHayConexionesLibresException, SQLException {
		List<String> lista = new LinkedList<String>();
		String consulta = "SELECT DISTINCT(categoria) from Producto";
		Conexion c = getConexionLibre();

		ResultSet r = c.execute(consulta);
		while (r.next()) {
			String cat = r.getString("categoria");
			if (!cat.equals("null") && !cat.isEmpty())
				lista.add(cat);
		}

		return lista;
	}

}
