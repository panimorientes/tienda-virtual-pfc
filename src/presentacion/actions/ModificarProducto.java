package presentacion.actions;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import domino.GestorProductos;
import excepciones.NoHayConexionesLibresException;

public class ModificarProducto extends ActionSupport {

	private int referencia;
	private String nombre;
	private String descripcion;
	private double precio;
	private String ruta_imagen;
	private int stock;
	private String categoria;

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public void setNombre(String nombre) {
		if (!nombre.isEmpty())
			this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		if (precio >= 0)
			this.precio = precio;
	}

	public void setRuta_imagen(String ruta_imagen) {
		if (!ruta_imagen.isEmpty())
			this.ruta_imagen = ruta_imagen;
		else
			this.ruta_imagen = "img/null-product2.png";
	}

	public void setStock(int stock) {
		if (stock >= 0)
			this.stock = stock;
	}

	public void setCategoria(String categoria) {
		if (!categoria.isEmpty())
			this.categoria = categoria;
		else
			this.categoria="Sin categoria";
	}

	public String execute() {

		try {
			GestorProductos ges = new GestorProductos();
			ges.modificarProducto(referencia, nombre, descripcion, precio,
					ruta_imagen, categoria, stock);
			return SUCCESS;
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		}
	}
}
