package pruebas;

import java.io.IOException;
import java.sql.SQLException;

import persistencia.AgenteBD;

import domino.Cliente;
import domino.GestorUsuarios;
import domino.Usuario;
import excepciones.NoHayConexionesLibresException;
import junit.framework.TestCase;

public class recuperarPassTest extends TestCase {

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
			String pass=g.recuperarPass("David@iso2.com");
			
			assertTrue(pass.equals("111111"));
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}

	}

	public void testTC2() {
		try {
			String correo="Prueba1@iso2.com";
			String pass="123456";
			GestorUsuarios g = new GestorUsuarios();
			g.crearCliente("Prueba1", "apellido TC1", correo, pass,
					"Calle donde vivo");
			
			String recuperada=g.recuperarPass(correo);
			assertTrue(recuperada.equals(pass));

		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}
	
	public void testTC3(){
		try {
			GestorUsuarios g=new GestorUsuarios();
			String correo="PruebaNoEstaEnBD@iso2.com";
			
			String recuperada=g.recuperarPass(correo);
			assertTrue(recuperada.equals(""));

		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}
	
	public void testTC4(){
		try {
			GestorUsuarios g=new GestorUsuarios();
			String correo="' fallo en sql'";
			
			String recuperada=g.recuperarPass(correo);
			fail("Se esperaba SQLException");

		} catch (SQLException e) {
			//fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}
}
