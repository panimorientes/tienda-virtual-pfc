package pruebas;

import java.io.IOException;
import java.sql.SQLException;

import persistencia.AgenteBD;
import persistencia.IAgenteBD;

import domino.Administrador;
import domino.Cliente;
import domino.GestorUsuarios;
import domino.Usuario;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class loginTest extends TestCase {

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
	
	public void testTC1()
	{
		try
		{
			GestorUsuarios g = new GestorUsuarios();
			Usuario u = (Cliente)g.login("David@iso2.com", "111111");
			assertTrue(u instanceof Cliente);
		}
		catch(SQLException e)
		{
			fail("No se esperaba SQLException");
		}
		catch (NoHayConexionesLibresException e)
		{
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
		
	}
	
	public void testTC2()
	{
		try
		{
			GestorUsuarios g = new GestorUsuarios();
			Usuario u = (Administrador)g.login("Guardiola@iso2.com", "111111");
			assertTrue(u instanceof Administrador);
		}
		catch(SQLException e)
		{
			fail("No se esperaba SQLException");
		}
		catch (NoHayConexionesLibresException e)
		{
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
		
	}
	
	public void testTC3()
	{
		try
		{
			GestorUsuarios g = new GestorUsuarios();
			Usuario u = g.login("' assdf email = 'jd'","2");
			fail("Se esperaba SQLException");
		}
		catch(SQLException e)
		{
		}
		catch (NoHayConexionesLibresException e)
		{
			fail("No se esperaba NoHayConexionesLibresExeption");
		}
	}
	
	public void testTC4()
	{
		try
		{
			Usuario u;
			GestorUsuarios g = new GestorUsuarios();
			for (int i = 0; i < (AgenteBD.numero_conexiones + 2); i++)
				u = g.login("David@iso2.com","111111");
			fail("Se esperaba NoHayConexionesLibresException");
		}
		catch(SQLException e)
		{
			fail("No se esperaba SQLException");
		}
		catch (NoHayConexionesLibresException e)
		{
			
		}
	}
}
