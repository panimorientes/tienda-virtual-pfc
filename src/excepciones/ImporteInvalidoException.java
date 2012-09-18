package excepciones;

public class ImporteInvalidoException extends Exception{
	public ImporteInvalidoException(){
		super();
	}
	
	public ImporteInvalidoException(String msg){
		super(msg);
	}
}
