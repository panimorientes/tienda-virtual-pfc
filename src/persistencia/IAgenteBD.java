package persistencia;

import java.sql.SQLException;
import domino.Cliente;
import domino.Usuario;
import excepciones.NoHayConexionesLibresException;

public interface IAgenteBD {

	public Usuario login(String correo, String pass)
			throws NoHayConexionesLibresException, SQLException;

	public Cliente crearCliente(String nombre, String apellido, String correo,
			String pass, String direccion)
			throws NoHayConexionesLibresException, SQLException;

	public Cliente getCliente(String correo)
			throws NoHayConexionesLibresException, SQLException;

	public void darBaja(String correo) throws NoHayConexionesLibresException,
			SQLException;

	public void modificarCliente(String nombre, String apellidos,
			String correo, String pass, String direccion)
			throws NoHayConexionesLibresException, SQLException;

	public String recuperarPass(String correo)
			throws NoHayConexionesLibresException, SQLException;

}
