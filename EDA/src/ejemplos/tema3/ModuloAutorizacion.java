package ejemplos.tema3;

import librerias.estructurasDeDatos.modelos.*; 
import librerias.estructurasDeDatos.deDispersion.*;
import librerias.excepciones.*;
import java.util.Date;

public class ModuloAutorizacion {
	private TablaHash<User, Date> m;
    
    public ModuloAutorizacion(int n) {
        // COMPLETAR
    	m = new TablaHash<User, Date>(n);
    }
    
    public Date fechaAcceso(String nombre, String pwd) {
        Date fecha = new Date();
        return fecha;
    }
//    
//    public void registrarUsuario(String nombre, String pwd) 
//        throws UsuarioExistente {
//        // COMPLETAR
//    }
//    
//    public boolean estaAutorizado(String nombre, String pwd) {
//        // COMPLETAR 
//    }
}