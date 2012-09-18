package presentacion.actions;

import java.sql.SQLException;

import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.GestorProductos;
import domino.GestorUsuarios;
import excepciones.NoHayConexionesLibresException;

public class ModificarUsuario extends ActionSupport{

	private String nombre;
	private String apellido;
	private String correo;
	private String pass;
	private String direccion;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String execute(){
		
		 try{
			 GestorUsuarios ges=new GestorUsuarios();
			 ges.modificarCliente(nombre, apellido, correo, pass, direccion);
			 WebUtils.getSession().setAttribute("user", ges.getCliente(correo));
			 return SUCCESS;
		 }catch(NoHayConexionesLibresException e){
			 return "NoHayConexionesLibresException";
		 }catch(SQLException e){
			 return "SQLException";
		 }
	 }
}
