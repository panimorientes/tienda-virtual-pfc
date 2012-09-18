package pruebas;

import java.io.IOException;
import java.sql.SQLException;

import domino.Cliente;
import domino.GestorUsuarios;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class darBajaTest extends TestCase {

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
			GestorUsuarios g = new GestorUsuarios();
			g.darBaja("David@iso2.com");
			Cliente c = g.getCliente("David@iso2.com");
			assertTrue(c == null);
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		}
	}

	public void testTC2() {
		try {
			GestorUsuarios g = new GestorUsuarios();
			g.darBaja("' sdfPedro");
			fail("Se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
		}
	}
}
