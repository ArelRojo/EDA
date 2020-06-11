package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.modelos.ListaConPIPlus;
import librerias.excepciones.ElementoNoEncontrado;

public class LEGListaConPIPlus<E> extends LEGListaConPI<E> implements ListaConPIPlus<E>{


	@Override
	public boolean contiene(E e) {
		NodoLEG<E> aux = pri;
		while(aux!=null) {
			if(aux.dato.equals(e)) {return true;}
			aux = aux.siguiente;
		}
		return false;
	}

	@Override
	public boolean eliminar(E e) {
		NodoLEG<E> aux = pri;
		while(aux!=null){
			if(aux.dato.equals(e)) {
				eliminar();
				return true;
			}
			aux = aux.siguiente;
		}
		return false;
	}

	@Override
	public E eliminarUltimo(E e) throws ElementoNoEncontrado {
		if(talla == 0) throw new ElementoNoEncontrado();
		NodoLEG<E> aux = pri;
		int cont = 0;
		int cont2 = 0;
		while (aux != null) {
			if(aux.dato.equals(e)) cont++;
			aux = aux.siguiente;
		} 
		E res = null;
		aux = pri;
		while(aux != null) {
			if(aux.dato.equals(e)) { cont2++;
			if(cont2 == cont) {
				res = aux.dato;
				eliminar();
			}
			}
			aux = aux.siguiente;
		}
		return res;
		
	}

	@Override
	public void eliminarTodos(E e) throws ElementoNoEncontrado {
		if(talla==0) throw new ElementoNoEncontrado();
		NodoLEG<E> aux = pri;
		while(aux!=null) {
			if(aux.dato.equals(e)) eliminar();
			aux = aux.siguiente;
		}
		
	}
	


	@Override
	public void vaciar() {
		NodoLEG<E> aux = pri;
		while(aux!=null) {
			eliminar();
			aux = aux.siguiente;
			
		}
	}

	@Override
	public void concatenar(ListaConPI<E> otra) {
		otra.inicio();
        while(!otra.esFin()){
            this.insertar(otra.recuperar());
            otra.siguiente();
        }  
		
	}

	@Override
	public void invertirDesdePI() {
		// TODO Auto-generated method stub
		
	}
	

}
