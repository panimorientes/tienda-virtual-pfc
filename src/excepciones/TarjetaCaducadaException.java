package excepciones;

public class TarjetaCaducadaException extends Exception{
	public TarjetaCaducadaException(){
		super();
	}
	
	public TarjetaCaducadaException(String msg){
		super(msg);
	}
}
