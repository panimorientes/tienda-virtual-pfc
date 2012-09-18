package excepciones;

public class MesInvalidoException extends Exception{

	public MesInvalidoException(){
		super();
	}
	
	public MesInvalidoException(String msg){
		super(msg);
	}
}
