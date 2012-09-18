package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import persistencia.AgenteBD;
import persistencia.IAgenteBD;

import domino.Carro;
import domino.Cliente;
import domino.GestorProductos;
import domino.PaqueteProducto;
import domino.Pedido;
import domino.Producto;
import excepciones.NoHayConexionesLibresException;

import junit.framework.TestCase;

public class guardarPedidoTest extends TestCase {

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
			GestorProductos g = new GestorProductos();
			List<Pedido> pedidos = g.pedidosCompletados("David@iso2.com");
			List<Pedido> pedidos_despues;
			List<PaqueteProducto> productos = new LinkedList<PaqueteProducto>();
			productos.add(new PaqueteProducto(new Producto(4, "Pantalón", "El mejor Pantalón", 3.0, "./ruta_imagen", "Ropa", 40), 1));
			Pedido p = new Pedido("2010/11/24", new Carro(productos));
			Cliente c = new Cliente ("David", "Suprimo", "David@iso2.com", "22222", "Calle Apestosa");
			g.guardarPedido(p, c);
			pedidos_despues = g.pedidosCompletados("David@iso2.com");
			assertTrue(pedidos.size() == pedidos_despues.size() - 1);
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}
	}
	
	public void testTC2()
	{
		try
		{
			GestorProductos g = new GestorProductos();
			List<Pedido> pedidos = g.pedidosCompletados("' asf");
			fail ("Se esperaba SQLException");
		} catch (SQLException e) {
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}
	}
	
	public void testTC3()
	{
		try {
			GeneradorHilos gen = new GeneradorHilos();
			gen.duerme();
			
			
			GestorProductos g = new GestorProductos();
			
			List<Pedido> pedidos = g.pedidosCompletados("David@iso2.com");
			List<Pedido> pedidos_despues;
			List<PaqueteProducto> productos = new LinkedList<PaqueteProducto>();
			
			productos.add(new PaqueteProducto(new Producto(4, "Pantalón", "El mejor Pantalón", 3.0, "./ruta_imagen", "Ropa", 40), 1));
			Pedido p = new Pedido("2010/11/24", new Carro(productos));
			Cliente c = new Cliente ("David", "Suprimo", "David@iso2.com", "22222", "Calle Apestosa");
			g.guardarPedido(p, c);

			fail ("Se esperaba NoHayConexionesLibresException");
			
		} catch (SQLException e) {
			fail ("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			System.out.println("Lee");
		}
	}

}
