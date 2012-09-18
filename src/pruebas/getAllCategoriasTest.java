package pruebas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import excepciones.NoHayConexionesLibresException;

import persistencia.AgenteBD;

import junit.framework.TestCase;

public class getAllCategoriasTest extends TestCase {

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
			AgenteBD a = new AgenteBD();
			
			List<String> lista_bd1=new LinkedList<String>();
			lista_bd1.add("Motos");
			lista_bd1.add("Zapatillas");
			
			List<String> lista = a.getAllCategorias();
			
			assertTrue(lista.containsAll(lista_bd1));
		} catch (SQLException e) {
			fail("No se esperaba SQLException");
		} catch (NoHayConexionesLibresException e) {
			fail("No se esperaba NoHayConexionesLibresException");
		}

	}
	
	public void testTC2(){
		
	}
}
