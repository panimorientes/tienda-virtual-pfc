package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import persistencia.AgenteBD;
import persistencia.IAgenteBD;

import domino.Cliente;
import domino.GestorUsuarios;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class crearClienteTest extends TestCase {

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
			Cliente c = g.crearCliente("Pepito", "Grillo", "Pepito@iso2.com",
					"22222", "Calle Atapuerca");
			assertTrue(c.getCorreo().equals("Pepito@iso2.com"));
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		}
	}

	public void testTC2() {
		try {
			GestorUsuarios g = new GestorUsuarios();
			Cliente c = g.crearCliente("' asdf email = '24'", "Grillo",
					"Pepito@iso2.com", "22222", "Calle Atapuerca");
			fail("Se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
		} 
	}

	public void testTC3() {
		try {
			GestorUsuarios g = new GestorUsuarios();
			Cliente c;
			int[] numeros = { 1, 2, 3 };
			for (int i = 0; i < AgenteBD.numero_conexiones + 1; i++) {
				c = g.crearCliente("Pepito", "Grillo",
						"\"" + numeros[i] + "\"", "22222", "Calle Atapuerca");
			}
			fail("Se esperaba NoHayConexionesLibresException");
		} catch (NoHayConexionesLibresException e) {
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		}
	}

}
