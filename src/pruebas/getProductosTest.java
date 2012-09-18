package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domino.GestorProductos;
import domino.Producto;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class getProductosTest extends TestCase {

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
			GestorProductos g = new GestorProductos();
			List<Producto> productos;
			productos = g.getProductos();
			assertTrue(productos.size() > 0);
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}
	}
}
