package pruebas;

import domino.Carro;
import domino.Producto;
import junit.framework.TestCase;

public class ModificarProductoCarroTest extends TestCase {

	public void setUp() {
		
	}

	public void testTC1() {
		Carro c = new Carro();
		c.addProducto(new Producto(4, "Pantalón", "El mejor Pantalón", 3.0,
				"./ruta_imagen", "Ropa", 40), 1);
		c.modificarProducto(4, 3);
		assertTrue(c.getLista_productos().get(0).getCantidad() == 3);
	}
	
	public void testTC2() {
		Carro c = new Carro();
		c.addProducto(new Producto(4, "Pantalón", "El mejor Pantalón", 3.0,
				"./ruta_imagen", "Ropa", 40), 1);
		c.modificarProducto(4, 100);
		assertTrue(c.getLista_productos().get(0).getCantidad() == 100);
	}
	
	public void testTC3() {
		Carro c = new Carro();
		c.addProducto(new Producto(4, "Pantalón", "El mejor Pantalón", 3.0,
				"./ruta_imagen", "Ropa", 40), 1);
		c.modificarProducto(55, 100);
		assertTrue(c.getLista_productos().get(0).getCantidad() == 100);
	}

}
