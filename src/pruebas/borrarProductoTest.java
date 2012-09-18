package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import domino.GestorProductos;
import domino.Producto;
import excepciones.NoHayConexionesLibresException;

public class borrarProductoTest extends TestCase {

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
			g.quitarProducto(1);
			List<Producto> productos = g.getProductos();
			assertTrue(!productos.contains(new Producto(1)));
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}
	}
	// En este método no se puede lanzar un SQLException
}
