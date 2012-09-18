package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domino.GestorProductos;
import domino.Producto;

import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class ModificarProductos extends TestCase {

	public void setUp() {
		Runtime aplicacion = Runtime.getRuntime();
		try {
			aplicacion.exec("./database/llenar_db.sh");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testTC1() {
		try {
			GestorProductos ges = new GestorProductos();

			Producto pro = new Producto(123123, "Prueba1",
					"Esto es de la prueba1", 549.9, "./img/null-product2.png",
					"Pruebas", 100);
			int referencia = ges.addProducto("Prueba1", "Esto es de la prueba1", 549.9,
					"./img/null-product2.png", "Pruebas", 100);

			ges.modificarProducto(referencia, "Cambio de nombre Prueba1",
					"Esto es de la prueba1", 549.9, "./img/null-product2.png",
					"Pruebas", 2);

			List<Producto> lista = ges.getProductos();
			pro.setReferencia(referencia);
			
			if (lista.contains(pro)) {
				int indice = lista.indexOf(pro);
				Producto pro2 = lista.get(indice);

				assertTrue(!pro.getNombre().equals(pro2.getNombre())
						&& pro.getUnidades() != pro2.getUnidades());
			} else {
				fail("No se ha obtenido bien el producto insertado");
			}
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}

	public void testTC2() {
		try {
			GestorProductos ges = new GestorProductos();
			double numero = 345.34;
			String nombre = "Cambio prueba2";

			int referencia = ges.addProducto("Prueba1", "Esto es de la prueba1", 549.9,
					"./imagenfalse.png", "Pruebas", 100);

			// modifico
			ges.modificarProducto(referencia, nombre, "Esto es de la prueba1",
					numero, "./imagenfalse.png", "Pruebas", 2);

			List<Producto> lista = ges.getProductos();
			Producto pro = new Producto(referencia, nombre,
					"Esto es de la prueba1", numero, "./imagenfalse.png",
					"Pruebas", 2);

			if (lista.contains(pro)) {
				int indice = lista.indexOf(pro);
				Producto pro2 = lista.get(indice);

				assertTrue(nombre.equals(pro2.getNombre())
						&& numero == pro2.getPrecio());
			} else {
				fail("No se ha encontrado el producto a modificar");
			}
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}

	public void testTC3() {
		try {
			GestorProductos ges = new GestorProductos();
			double numero = 345.34;
			String nombre = "Cambio prueba2";

			ges.modificarProducto(123, nombre, "'Esto es de la prueba3'",
					numero, "./imagenfalse.png", "Pruebas", 2);

			List<Producto> lista = ges.getProductos();

			fail("Se esperaba SQLException");

		} catch (SQLException e) {
			// fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}

}
