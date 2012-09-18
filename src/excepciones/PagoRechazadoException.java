package excepciones;

public class PagoRechazadoException extends Exception{

	public PagoRechazadoException(){
		super();
	}
	
	public PagoRechazadoException(String msg){
		super(msg);
	}
}
