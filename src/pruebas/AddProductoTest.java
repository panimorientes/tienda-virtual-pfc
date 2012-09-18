package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domino.GestorProductos;
import domino.Producto;

import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class AddProductoTest extends TestCase {

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
			List<Producto> lista_antes = ges.getProductos();
			Producto pro = new Producto(12432, "Prueba1",
					"Esto es de la prueba1", 549.9, "./img/null-product2.png",
					"Pruebas", 100);
			ges.addProducto("Prueba1", "Esto es de la prueba1", 549.9,
					"./img/null-product2.png", "Pruebas", 100);
			List<Producto> lista_despues = ges.getProductos();
			assertTrue(lista_antes.size() + 1 == lista_despues.size());
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}

	public void testTC2() {
		try {
			GestorProductos ges = new GestorProductos();

			ges.addProducto("'Prueba1  con error '", "Esto es de la prueba1",
					549.9, "./imagenfalse.png", "Pruebas", 100);

			fail("Se esperaba SQLException");

		} catch (SQLException e) {
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}

	public void testTC3() {
		try {
			GestorProductos ges = new GestorProductos();
			Producto pro = new Producto(123123, "Prueba1",
					"Esto es de la prueba1", 549.9, "./imagenfalse.png",
					"Pruebas", 100);
			ges.addProducto("Prueba1", "Esto es de la prueba1", 549.9,
					"./imagenfalse.png", "Pruebas", 100);
			ges.addProducto("Prueba2", "Esto es de la prueba1", 549.9,
					"./imagenfalse.png", "Pruebas", 100);

			fail("Se esperaba SQLException");

		} catch (SQLException e) {
			// fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}
}
