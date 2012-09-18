package domino;

public class Cliente extends Usuario {

	private String direccion;
	
	public Cliente(String correo) {
		super(correo);
	}

	public Cliente(String nombre, String apellido, String correo,
			String contraseña, String direccion) {
		super(nombre, apellido, correo, contraseña);
		this.direccion = direccion;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
