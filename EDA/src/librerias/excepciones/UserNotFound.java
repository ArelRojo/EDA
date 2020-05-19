package librerias.excepciones;

public class UserNotFound extends Exception {
	
	    public UserNotFound(String mensaje) {
	        super(mensaje);
	    }    
	    public UserNotFound() { 
	        super();
	    }
	
}
