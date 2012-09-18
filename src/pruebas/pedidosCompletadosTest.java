package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import persistencia.AgenteBD;
import persistencia.IAgenteBD;

import domino.GestorProductos;
import domino.Pedido;
import domino.Producto;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class pedidosCompletadosTest extends TestCase{
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
		try {
			GestorProductos g = new GestorProductos();
			List<Pedido> pedidos;
			pedidos = g.pedidosCompletados("David@iso2.com");
			assertTrue(pedidos.size() >= 0 && pedidos.size() <= 3);
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}
	}
	
	public void testTC2()
	{
		try {
			GestorProductos g = new GestorProductos();
			List<Pedido> pedidos;
			pedidos = g.pedidosCompletados("' asdfkf");
			fail ("Se esperaba SQLException");
		} catch (SQLException e) {
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}
	}
	
	public void testTC3()
	{
		try {
			GestorProductos g = new GestorProductos();
			List<Pedido> pedidos;
			for (int i = 0; i < AgenteBD.numero_conexiones + 1; i++)
				pedidos = g.pedidosCompletados("David@iso2.com");	
			fail ("Se esperaba NoHayConexionesLibresException");
		} catch (SQLException e) {
			fail ("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
		}
	}
	
}
