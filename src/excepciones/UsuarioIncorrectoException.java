package excepciones;

public class UsuarioIncorrectoException extends Exception{
	public UsuarioIncorrectoException(){
		super();
	}
	
	public UsuarioIncorrectoException(String msg){
		super(msg);
	}
}
