package domino;


import java.sql.SQLException;

import excepciones.NoHayConexionesLibresException;
import persistencia.AgenteBD;
import persistencia.IAgenteBD;

public class GestorUsuarios{
	private IAgenteBD i;
	

	public GestorUsuarios() throws SQLException{
		i=new AgenteBD();
	}
	
	public Usuario login(String correo, String pass)
			throws NoHayConexionesLibresException, SQLException
			{
				return i.login(correo, pass);
			}

	public Cliente crearCliente(String nombre, String apellido, String correo,
			String pass, String direccion)
			throws NoHayConexionesLibresException, SQLException
			{
				return i.crearCliente(nombre, apellido, correo, pass, direccion);
			}

	public Cliente getCliente(String correo)
			throws NoHayConexionesLibresException, SQLException
			{
				return i.getCliente(correo);
			}

	public void darBaja(String correo) throws NoHayConexionesLibresException,
			SQLException
			{
				i.darBaja(correo);
			}

	public void modificarCliente(String nombre, String apellidos,
			String correo, String pass, String direccion)
			throws NoHayConexionesLibresException, SQLException
			{
				i.modificarCliente(nombre, apellidos, correo, pass, direccion);
			}

	public String recuperarPass(String correo)
			throws NoHayConexionesLibresException, SQLException
			{
				return i.recuperarPass(correo);
			}
	

}
