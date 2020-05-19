package librerias.excepciones;

public class NotaNoEncontradaException extends Exception {
	 public NotaNoEncontradaException(String mensaje) {
	        super(mensaje);
	    }    
	    public NotaNoEncontradaException() { 
	        super();
	    }
}
