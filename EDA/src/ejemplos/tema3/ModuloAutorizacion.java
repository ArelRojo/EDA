
package ejemplos.tema3;

import librerias.estructurasDeDatos.modelos.*;
import librerias.estructurasDeDatos.deDispersion.*;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;

import librerias.excepciones.UsuarioExistente;

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

	public void registrarUsuario(String nombre, String pwd) throws UsuarioExistente {
		if (m.recuperar(new User(nombre, pwd)) != null) {
			throw new UsuarioExistente("Ya existe " + nombre);
		} else {
			m.insertar(new User(nombre, pwd), null);
		}
	}

	public boolean estaAutorizado(String nombre, String pwd) {
		// COMPLETAR
		LEGListaConPI<User> users = (LEGListaConPI<User>) m.claves();
		String stored_pass = null;
		users.inicio();
		while(!users.esFin()) {
			if(users.recuperar().getName().equals(nombre)) {
				stored_pass = users.recuperar().getPassword();
			}
			users.siguiente();
		}
		if(stored_pass != null && stored_pass.equals(pwd)) {
			return true;
		}else return false;
	}
}