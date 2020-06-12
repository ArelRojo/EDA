package librerias.estructurasDeDatos.lineales;
import java.util.NoSuchElementException;

import librerias.estructurasDeDatos.modelos.*;
import librerias.excepciones.ElementoNoEncontrado;

public class LEGCola<E> implements Cola<E> {
	
	protected NodoLEG<E> first;
	protected NodoLEG<E> last;
	protected int size;
	
	/**Constructor Cola vacia*/
	public LEGCola() {
		first = last = null; size = 0;
	}
	
	@Override
	public void encolar(E e) {
		NodoLEG<E> n = new NodoLEG<E>(e);
		if(last!=null) {last.siguiente = n;}
		else{first = n;}
		last = n;
		size++;
	}

	@Override
	public E desencolar() {
		if(size==0)throw new NoSuchElementException();
		E aux = first.dato;
		first = first.siguiente;
		if(first==null) {last = null;}
		size--;
		return aux;
	}

	@Override
	public E primero() {
		if(size==0) throw new NoSuchElementException();
		return first.dato;
	}

	@Override
	public boolean esVacia() {
		return size == 0;
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		 StringBuilder res = new StringBuilder();
	     res.append("[");
	     NodoLEG<E> aux = first.siguiente;
	     for (int i = 1; i < size; i++, aux = aux.siguiente) {            
	            res.append(aux.dato.toString() + ", ");
	        }
	        if (size != 0) {
	            res.append(aux.dato.toString() + "]"); 
	        } else { res.append("]"); }
	        return res.toString();
	    }
	}

