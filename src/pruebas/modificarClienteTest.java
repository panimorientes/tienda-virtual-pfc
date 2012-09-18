package pruebas;

import java.io.IOException;
import java.sql.SQLException;

import domino.Cliente;
import domino.GestorUsuarios;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class modificarClienteTest extends TestCase{
	public void setUp()
	{
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
	
	public void testTC1()
	{
		try
		{
			GestorUsuarios g = new GestorUsuarios();
			g.modificarCliente("Pedro", "Alcántara", "David@iso2.com", "asdjfj", "Calle Postas");
			Cliente c = g.getCliente("David@iso2.com");
			assertTrue(c.getNombre().equals("Pedro") && c.getApellido().equals("Alcántara") && c.getContraseña().equals("asdjfj") && c.getDireccion().equals("Calle Postas"));
		}
		catch(NoHayConexionesLibresException e)
		{
			fail ("No se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		}
	}
	
	public void testTC2()
	{
		try
		{
			GestorUsuarios g = new GestorUsuarios();
			g.modificarCliente("' sdfPedro", "Alcántara", "David@iso2.com", "asdjfj", "Calle Postas");
			fail("Se esperaba SQLException");
		}
		catch(NoHayConexionesLibresException e)
		{
			fail("No se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
		}
	
	}
}
